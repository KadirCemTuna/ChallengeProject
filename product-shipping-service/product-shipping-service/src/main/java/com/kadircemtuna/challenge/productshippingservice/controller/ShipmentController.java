package com.kadircemtuna.challenge.productshippingservice.controller;

import com.kadircemtuna.challenge.productshippingservice.common.CreateShipmentRequest;
import com.kadircemtuna.challenge.productshippingservice.dto.Shipment;
import com.kadircemtuna.challenge.productshippingservice.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {
  @Autowired
  private ShipmentService shipmentService;

  @GetMapping("/{saleId}")
  public ResponseEntity<Shipment> inquireShipment(@PathVariable("saleId") Long saleId) {
    Shipment shipment = this.shipmentService.inquireShipment(saleId);
    if (shipment != null) {
      return new ResponseEntity<Shipment>(shipment, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  @PostMapping()
  public ResponseEntity<Shipment> createShipment(@RequestBody CreateShipmentRequest request) throws ValidationException {
    Shipment shipment = this.shipmentService.createShipment(request);
    if (shipment != null) {
      return new ResponseEntity<Shipment>(shipment, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/dummy")
  public ResponseEntity<Void> createDummyShipment() throws ValidationException {
    this.shipmentService.createDummyShipment();
    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }
}
