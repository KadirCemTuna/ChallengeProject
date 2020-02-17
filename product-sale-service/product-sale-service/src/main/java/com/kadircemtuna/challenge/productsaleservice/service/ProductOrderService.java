package com.kadircemtuna.challenge.productsaleservice.service;

import com.kadircemtuna.challenge.productsaleservice.dto.ProductOrder;

import javax.xml.bind.ValidationException;

public interface ProductOrderService {
  ProductOrder createProductOrder(ProductOrder productOrder) throws ValidationException;

  ProductOrder inquireProductOrder(Long orderId);

  ProductOrder createDummyProductOrder();
}
