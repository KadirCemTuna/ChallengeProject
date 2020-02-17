package com.kadircemtuna.challenge.productshippingservice.controller;

import com.kadircemtuna.challenge.productshippingservice.dto.Shipment;
import com.kadircemtuna.challenge.productshippingservice.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {
  @Autowired
  private ShipmentService shipmentService;

  @GetMapping("/{saleId}")
  public Shipment inquireShipment(@PathVariable("saleId") Long saleId) {
    return this.shipmentService.inquireShipment(saleId);
  }
}
