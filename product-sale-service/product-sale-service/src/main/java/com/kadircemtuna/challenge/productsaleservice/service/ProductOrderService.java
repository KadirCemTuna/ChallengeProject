package com.kadircemtuna.challenge.productsaleservice.service;

import com.kadircemtuna.challenge.productsaleservice.dto.ProductOrder;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface ProductOrderService {
  void createProductOrder(List<Long> productIds) throws ValidationException;

  ProductOrder inquireProductOrder(Long orderId);

  void createDummyProductOrder() throws ValidationException;
}
