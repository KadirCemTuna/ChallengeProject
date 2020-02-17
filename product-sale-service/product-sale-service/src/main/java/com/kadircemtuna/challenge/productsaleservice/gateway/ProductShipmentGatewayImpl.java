package com.kadircemtuna.challenge.productsaleservice.gateway;

import com.kadircemtuna.challenge.productsaleservice.dto.Shipment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductShipmentGatewayImpl implements ProductShipmentGateway {
  @Override
  public Shipment inquireShipment(Long saleId) {
    String url = "http://localhost:8083/shipment/" + saleId.toString();
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(url, Shipment.class);
  }
}
