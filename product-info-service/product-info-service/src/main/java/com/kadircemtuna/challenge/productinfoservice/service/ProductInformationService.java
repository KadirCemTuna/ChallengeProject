package com.kadircemtuna.challenge.productinfoservice.service;

import com.kadircemtuna.challenge.productinfoservice.dto.Product;

import javax.xml.bind.ValidationException;

public interface ProductInformationService {
  Product inquireProduct(Long productId);

  Product createProduct(Product product) throws ValidationException;

  Product createDummyProduct() throws ValidationException;
}
