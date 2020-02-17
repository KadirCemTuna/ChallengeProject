package com.kadircemtuna.challenge.productinfoservice.controller;

import com.kadircemtuna.challenge.productinfoservice.entity.ProductEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class productInformationController {

  @GetMapping("/{productId}")
  public ProductEntity inquireProduct(@PathVariable("productId") Long productId) {
    return new ProductEntity(1L, "ACTV", 512.5D, "klavye","path");
  }
}
