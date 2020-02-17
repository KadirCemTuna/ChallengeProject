package com.kadircemtuna.challenge.productinfoservice.controller;

import com.kadircemtuna.challenge.productinfoservice.dto.Product;
import com.kadircemtuna.challenge.productinfoservice.service.ProductInformationService;
import org.apache.tomcat.util.modeler.OperationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Operation;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/product")
public class ProductInformationController {

  @Autowired
  public ProductInformationService productInformationService;

  @GetMapping("/{productId}")
  public Product inquireProduct(@PathVariable("productId") Long productId) throws ValidationException {
    Product product = this.productInformationService.inquireProduct(productId);
    if (product != null)
      return product;
    else
      throw new ValidationException("There is no such a product with this id");
  }

  @PostMapping()
  public void createProduct(@RequestBody Product product) throws ValidationException {
    this.productInformationService.createProduct(product);
  }

  @GetMapping("/dummy")
  public Product createDummyProduct() throws ValidationException {
   return this.productInformationService.createDummyProduct();
  }
}
