package com.kadircemtuna.challenge.productsaleservice.controller;

import com.kadircemtuna.challenge.productsaleservice.common.CreateProductOrderRequest;
import com.kadircemtuna.challenge.productsaleservice.dto.ProductOrder;
import com.kadircemtuna.challenge.productsaleservice.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class ProductOrderController {
  @Autowired
  private ProductOrderService productOrderService;

  @GetMapping("/{saleId}")
  public ResponseEntity<ProductOrder> inquireProductOrder(@PathVariable("saleId") Long orderId) {
    ProductOrder productOrder = this.productOrderService.inquireProductOrder(orderId);
    if (productOrder != null) {
      return new ResponseEntity<ProductOrder>(productOrder, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  @PostMapping()
  public ResponseEntity<Void> createProductOrder(@RequestBody CreateProductOrderRequest request) throws ValidationException {
    this.productOrderService.createProductOrder(request.getProductIdList());
    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }

  @GetMapping("/dummy")
  public ResponseEntity<Void> createDummyProductOrder() throws ValidationException {
    this.productOrderService.createDummyProductOrder();
    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }
}
