package com.kadircemtuna.challenge.productinfoservice.controller;

import com.kadircemtuna.challenge.productinfoservice.dto.Product;
import com.kadircemtuna.challenge.productinfoservice.service.ProductInformationService;
import org.apache.tomcat.util.modeler.OperationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
