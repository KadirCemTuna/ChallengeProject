package com.kadircemtuna.challenge.productshippingservice.service;

import com.kadircemtuna.challenge.productshippingservice.dto.Shipment;

public interface ShipmentService {

  Shipment inquireShipment(Long saleId);
}
