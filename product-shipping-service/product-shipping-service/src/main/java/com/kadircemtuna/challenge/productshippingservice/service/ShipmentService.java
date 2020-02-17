package com.kadircemtuna.challenge.productshippingservice.service;

import com.kadircemtuna.challenge.productshippingservice.common.CreateShipmentRequest;
import com.kadircemtuna.challenge.productshippingservice.dto.Shipment;

import javax.xml.bind.ValidationException;

public interface ShipmentService {

  Shipment inquireShipment(Long saleId);

  Shipment createShipment(CreateShipmentRequest request) throws ValidationException;

  void createDummyShipment() throws ValidationException;
}
