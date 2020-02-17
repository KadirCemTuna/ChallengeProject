package com.kadircemtuna.challenge.productinfoservice.service;

import com.kadircemtuna.challenge.productinfoservice.common.GeneralEnumeration;
import com.kadircemtuna.challenge.productinfoservice.dto.Product;
import com.kadircemtuna.challenge.productinfoservice.entity.ProductEntity;
import com.kadircemtuna.challenge.productinfoservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductInformationServiceImpl implements ProductInformationService {
  @Autowired
  private ProductRepository productRepository;

  @Override
  public Product inquireProduct(Long productId) {
    Optional<ProductEntity> productEntity = this.productRepository.findById(productId);
    if (productEntity.isPresent()) {
      Product product = this.buildProduct(productEntity.get());
      return product;
    }
    return null;
  }

  private Product buildProduct(ProductEntity productEntity) {
    Product product = new Product();
    product.setId(productEntity.getProductId());
    product.setName(productEntity.getName());
    product.setPrice(productEntity.getPrice());
    product.setImage(productEntity.getImage());
    product.setStatus(productEntity.getStatus());
    return product;
  }

  @Override
  public void addProduct(Product product) {

  }
}
