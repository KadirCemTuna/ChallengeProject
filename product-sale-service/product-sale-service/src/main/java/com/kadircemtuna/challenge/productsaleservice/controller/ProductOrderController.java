package com.kadircemtuna.challenge.productsaleservice.controller;

import com.kadircemtuna.challenge.productsaleservice.dto.ProductOrder;
import com.kadircemtuna.challenge.productsaleservice.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/productOrder")
public class ProductOrderController {
  @Autowired
  private ProductOrderService productOrderService;

  @GetMapping("/{orderId}")
  public ProductOrder inquireProductOrder(@PathVariable("orderId") Long orderId){
    return this.productOrderService.inquireProductOrder(orderId);
  }

  @PostMapping()
  public void createProductOrder(@RequestBody List<Long> productIdList) throws ValidationException {
    this.productOrderService.createProductOrder(productIdList);

  }
}
