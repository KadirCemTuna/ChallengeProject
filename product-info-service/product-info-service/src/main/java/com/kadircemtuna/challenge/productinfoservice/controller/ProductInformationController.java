package com.kadircemtuna.challenge.productinfoservice.controller;

import com.kadircemtuna.challenge.productinfoservice.dto.Product;
import com.kadircemtuna.challenge.productinfoservice.service.ProductInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductInformationController {

  @Autowired
  public ProductInformationService productInformationService;

  @GetMapping("/{productId}")
  public Product inquireProduct(@PathVariable("productId") Long productId) {
    return this.productInformationService.inquireProduct(productId);
  }

}
