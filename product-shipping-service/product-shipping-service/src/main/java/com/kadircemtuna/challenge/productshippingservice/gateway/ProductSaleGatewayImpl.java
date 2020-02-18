package com.kadircemtuna.challenge.productshippingservice.gateway;

import com.kadircemtuna.challenge.productshippingservice.dto.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ProductSaleGatewayImpl implements ProductSaleGateway {
  @Autowired
  private WebClient.Builder webClientBuilder;

  @Override
  public ProductOrder inquireProductOrder(Long orderId) {
    String url = "http://localhost:8081/sale/" + orderId.toString();

    ProductOrder productOrder = this.webClientBuilder.build()
        .get()
        .uri(url)
        .retrieve()
        .bodyToFlux(ProductOrder.class)
        .blockFirst();

    return productOrder;
  }
}
