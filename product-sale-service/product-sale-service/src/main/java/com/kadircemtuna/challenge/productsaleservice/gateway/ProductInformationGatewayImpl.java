package com.kadircemtuna.challenge.productsaleservice.gateway;

import com.kadircemtuna.challenge.productsaleservice.dto.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductInformationGatewayImpl implements ProductInformationGateway {
  @Override
  public Product inquireProduct(Long productId) {
    String url = "http://localhost:8080/product/" + productId.toString();
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(url, Product.class);
  }
}
