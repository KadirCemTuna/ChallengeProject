package com.kadircemtuna.challenge.productshippingservice.gateway;

import com.kadircemtuna.challenge.productshippingservice.dto.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductSaleGatewayImpl implements ProductSaleGateway {
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public ProductOrder inquireProductOrder(Long orderId) {
    String url = "http://localhost:8081/sale/" + orderId.toString();
    return this.restTemplate.getForObject(url, ProductOrder.class);
  }
}
