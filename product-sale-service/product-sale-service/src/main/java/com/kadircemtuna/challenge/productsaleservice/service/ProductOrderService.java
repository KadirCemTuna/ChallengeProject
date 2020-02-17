package com.kadircemtuna.challenge.productsaleservice.service;

import com.kadircemtuna.challenge.productsaleservice.dto.ProductOrder;
import com.kadircemtuna.challenge.productsaleservice.dto.Shipment;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface ProductOrderService {
  void createProductOrder(List<Long> productIds) throws ValidationException;

  ProductOrder inquireProductOrder(Long orderId);

  void createDummyProductOrder() throws ValidationException;

  Shipment inquireShipment(Long orderId);
}
