package com.kadircemtuna.challenge.productsaleservice.gateway;

import com.kadircemtuna.challenge.productsaleservice.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ProductInformationGatewayImpl implements ProductInformationGateway {
  @Autowired
  private WebClient.Builder webClientBuilder;

  @Override
  public Product inquireProduct(Long productId) {
    String url = "http://localhost:8080/product/" + productId.toString();

    Product product = this.webClientBuilder.build()
        .get()
        .uri(url)
        .retrieve()
        .bodyToMono(Product.class)
        .block();

    return product;
  }
}
