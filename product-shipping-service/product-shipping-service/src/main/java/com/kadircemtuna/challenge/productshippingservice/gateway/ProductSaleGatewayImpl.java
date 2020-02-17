package com.kadircemtuna.challenge.productshippingservice.gateway;

import com.kadircemtuna.challenge.productshippingservice.dto.ProductOrder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductSaleGatewayImpl implements ProductSaleGateway {
  @Override
  public ProductOrder inquireProductOrder(Long orderId) {
    String url = "http://localhost:8081/sale/" + orderId.toString();
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(url, ProductOrder.class);
  }
}
