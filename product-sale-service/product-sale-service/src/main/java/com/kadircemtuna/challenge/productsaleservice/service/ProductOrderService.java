package com.kadircemtuna.challenge.productsaleservice.service;

import com.kadircemtuna.challenge.productsaleservice.dto.ProductOrder;

public interface ProductOrderService {
  ProductOrder inquireProductOrder(Long orderId);
}
