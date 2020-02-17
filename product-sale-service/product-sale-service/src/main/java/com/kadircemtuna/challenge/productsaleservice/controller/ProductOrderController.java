package com.kadircemtuna.challenge.productsaleservice.controller;

import com.kadircemtuna.challenge.productsaleservice.dto.ProductOrder;
import com.kadircemtuna.challenge.productsaleservice.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productOrder")
public class ProductOrderController {
  @Autowired
  private ProductOrderService productOrderService;

  @GetMapping("/{orderId}")
  public ProductOrder inquireProductOrder(@PathVariable("orderId") Long orderId){
    return this.productOrderService.inquireProductOrder(orderId);
  }
}
