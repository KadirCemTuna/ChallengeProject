package com.kadircemtuna.challenge.productsaleservice.gateway;

import com.kadircemtuna.challenge.productsaleservice.dto.Shipment;

public interface ProductShipmentGateway {
  Shipment inquireShipment(Long saleId);
}
