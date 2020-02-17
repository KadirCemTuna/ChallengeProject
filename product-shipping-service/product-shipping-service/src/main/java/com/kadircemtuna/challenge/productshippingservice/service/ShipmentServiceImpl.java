package com.kadircemtuna.challenge.productshippingservice.service;

import com.kadircemtuna.challenge.productshippingservice.common.GeneralEnumeration;
import com.kadircemtuna.challenge.productshippingservice.dto.Shipment;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ShipmentServiceImpl implements ShipmentService {
  @Override
  public Shipment inquireShipment(Long saleId) {
    Shipment shipment = new Shipment();
    shipment.setSaleId(1L);
    shipment.setStatus(GeneralEnumeration.ShipmentStatus.EnRoute.name());
    shipment.setCreatedAt(new Date());
    return shipment;
  }
}
