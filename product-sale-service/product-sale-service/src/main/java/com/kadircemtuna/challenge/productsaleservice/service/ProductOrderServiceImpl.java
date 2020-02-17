package com.kadircemtuna.challenge.productsaleservice.service;

import com.kadircemtuna.challenge.productsaleservice.dto.Product;
import com.kadircemtuna.challenge.productsaleservice.dto.ProductOrder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
  @Override
  public ProductOrder inquireProductOrder(Long orderId) {
    RestTemplate restTemplate = new RestTemplate();
    Product template = restTemplate.getForObject("http://localhost:8080/product/123", Product.class);

    ProductOrder productOrder = new ProductOrder();
    productOrder.setProduct(template);
    productOrder.setSaleCode(UUID.randomUUID().toString());
    productOrder.setProductOrderId(123L);
    return productOrder;
  }
}
