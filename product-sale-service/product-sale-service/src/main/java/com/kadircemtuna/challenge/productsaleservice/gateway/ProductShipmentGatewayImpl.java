package com.kadircemtuna.challenge.productsaleservice.gateway;

import com.kadircemtuna.challenge.productsaleservice.dto.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ProductShipmentGatewayImpl implements ProductShipmentGateway {
  @Autowired
  private WebClient.Builder webClientBuilder;

  @Override
  public Shipment inquireShipment(Long saleId) {
    String url = "http://product-shipment-service/shipment/" + saleId.toString();

    Shipment shipment = this.webClientBuilder.build()
        .get()
        .uri(url)
        .retrieve()
        .bodyToMono(Shipment.class)
        .block();

    return shipment;
  }
}
