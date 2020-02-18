package com.kadircemtuna.challenge.productsaleservice.gateway;

import com.kadircemtuna.challenge.productsaleservice.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductInformationGatewayImpl implements ProductInformationGateway {
  @Autowired
  private RestTemplate restTemplate;
  @Override
  public Product inquireProduct(Long productId) {
    String url = "http://localhost:8080/product/" + productId.toString();
    return this.restTemplate.getForObject(url, Product.class);
  }
}
