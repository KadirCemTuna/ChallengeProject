package com.kadircemtuna.challenge.productinfoservice.controller;

import com.kadircemtuna.challenge.productinfoservice.dto.Product;
import com.kadircemtuna.challenge.productinfoservice.service.ProductInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/product")
public class ProductInformationController {

  @Autowired
  public ProductInformationService productInformationService;

  @GetMapping("/{productId}")
  public ResponseEntity<Product> inquireProduct(@PathVariable("productId") Long productId) throws ValidationException {
    Product product = this.productInformationService.inquireProduct(productId);
    if (product != null)
      return new ResponseEntity<Product>(product, HttpStatus.OK);
    else
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping()
  public ResponseEntity<Void> createProduct(@RequestBody Product product) throws ValidationException {
    this.productInformationService.createProduct(product);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/dummy")
  public ResponseEntity<Product> createDummyProduct() throws ValidationException {
    Product product = this.productInformationService.createDummyProduct();
    return new ResponseEntity<Product>(product, HttpStatus.CREATED);
  }
}
