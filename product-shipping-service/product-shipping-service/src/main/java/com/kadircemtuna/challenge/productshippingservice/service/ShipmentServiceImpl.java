package com.kadircemtuna.challenge.productshippingservice.service;

import com.kadircemtuna.challenge.productshippingservice.dto.ProductOrder;
import com.kadircemtuna.challenge.productshippingservice.dto.Shipment;
import com.kadircemtuna.challenge.productshippingservice.entity.ShipmentEntity;
import com.kadircemtuna.challenge.productshippingservice.gateway.ProductSaleGateway;
import com.kadircemtuna.challenge.productshippingservice.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
