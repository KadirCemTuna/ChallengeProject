package com.kadircemtuna.challenge.productshippingservice.service;

import com.kadircemtuna.challenge.productshippingservice.common.CreateShipmentRequest;
import com.kadircemtuna.challenge.productshippingservice.common.GeneralEnumeration;
import com.kadircemtuna.challenge.productshippingservice.dto.ProductOrder;
import com.kadircemtuna.challenge.productshippingservice.dto.Shipment;
import com.kadircemtuna.challenge.productshippingservice.entity.ShipmentEntity;
import com.kadircemtuna.challenge.productshippingservice.gateway.ProductSaleGateway;
import com.kadircemtuna.challenge.productshippingservice.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.xml.bind.ValidationException;
import java.util.Date;

@Service
public class ShipmentServiceImpl implements ShipmentService {
  @Autowired
  private ShipmentRepository shipmentRepository;
  @Autowired
  private ProductSaleGateway productSaleGateway;

  @Override
  public Shipment inquireShipment(Long saleId) {
    ShipmentEntity shipmentEntity = this.shipmentRepository.findBySaleId(saleId);
    if (shipmentEntity != null) {
      Shipment shipment = new Shipment();
      ProductOrder productOrder = this.productSaleGateway.inquireProductOrder(saleId);
      shipment.setProductOrder(productOrder);
      shipment.setCreatedAt(shipmentEntity.getCreatedAt());
      shipment.setStatus(shipmentEntity.getStatus());
      shipment.setSaleId(saleId);
      return shipment;
    }
    return null;
  }

  @Override
  public Shipment createShipment(CreateShipmentRequest request) throws ValidationException {
    this.validateCreateShipmentRequest(request);

    ProductOrder productOrder = this.productSaleGateway.inquireProductOrder(request.getSaleId());
    if (productOrder != null) {
      ShipmentEntity shipmentEntity = new ShipmentEntity();
      shipmentEntity.setCreatedAt(new Date());
      shipmentEntity.setSaleId(request.getSaleId());
      shipmentEntity.setStatus(request.getStatus());
      this.shipmentRepository.save(shipmentEntity);

      return this.buildShipment(request, productOrder);
    }
    return null;
  }

  private Shipment buildShipment(CreateShipmentRequest request, ProductOrder productOrder) {
    Shipment shipment = new Shipment();
    shipment.setProductOrder(productOrder);
    shipment.setSaleId(request.getSaleId());
    shipment.setStatus(request.getStatus());
    shipment.setCreatedAt(new Date());
    return shipment;
  }

  private void validateCreateShipmentRequest(CreateShipmentRequest request) throws ValidationException {
    if (request.getSaleId() == null || request.getSaleId() < 0L)
      throw new ValidationException("validateCreateShipmentRequest, SaleId is mandatory");
    if (StringUtils.isEmpty(request.getStatus()))
      throw new ValidationException("validateCreateShipmentRequest, Status is mandatory");
  }

  @Override
  public void createDummyShipment() throws ValidationException {
    for (int i = 0; i < 5; i++) {
      CreateShipmentRequest createShipmentRequest = new CreateShipmentRequest();
      createShipmentRequest.setStatus(GeneralEnumeration.ShipmentStatus.EnRoute.name());
      createShipmentRequest.setSaleId((long) i);
      this.createShipment(createShipmentRequest);
    }
  }
}
