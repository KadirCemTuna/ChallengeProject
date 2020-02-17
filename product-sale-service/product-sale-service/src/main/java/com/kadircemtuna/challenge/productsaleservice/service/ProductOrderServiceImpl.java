package com.kadircemtuna.challenge.productsaleservice.service;

import com.kadircemtuna.challenge.productsaleservice.dto.ProductOrder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
  @Override
  public ProductOrder inquireProductOrder(Long orderId) {
    ProductOrder productOrder = new ProductOrder();
    productOrder.setProductId(1L);
    productOrder.setSaleCode(UUID.randomUUID().toString());
    productOrder.setProductOrderId(123L);
    return productOrder;
  }
}
