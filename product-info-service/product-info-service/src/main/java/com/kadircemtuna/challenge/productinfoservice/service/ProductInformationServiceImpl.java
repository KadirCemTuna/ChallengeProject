package com.kadircemtuna.challenge.productinfoservice.service;

import com.kadircemtuna.challenge.productinfoservice.dto.Product;
import com.kadircemtuna.challenge.productinfoservice.entity.ProductEntity;
import com.kadircemtuna.challenge.productinfoservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ProductInformationServiceImpl implements ProductInformationService {
  @Autowired
  private ProductRepository productRepository;

  @Override
  public Product inquireProduct(Long productId) {
    Optional<ProductEntity> productEntity = this.productRepository.findById(productId);
    return productEntity.map(this::buildProduct).orElse(null);
  }

  private Product buildProduct(ProductEntity productEntity) {
    Product product = new Product();
    product.setId(productEntity.getProductId());
    product.setName(productEntity.getName());
    product.setPrice(productEntity.getPrice());
    product.setImage(productEntity.getImage());
    product.setCategory(productEntity.getCategory());
    return product;
  }

  @Override
  public void createProduct(Product product) throws ValidationException {
    this.validateProduct(product);

    ProductEntity productEntity = this.buildProductEntity(product);
    this.productRepository.save(productEntity);
  }

  private void validateProduct(Product product) throws ValidationException {
    if (product.getName().isEmpty())
      throw new ValidationException("validateProduct, name is mandatory.");
    if (product.getPrice() == null || product.getPrice() < 0D)
      throw new ValidationException("validateProduct, price is mandatory.");
    if (product.getCategory().isEmpty())
      throw new ValidationException("validateProduct, category is mandatory.");
  }

  private ProductEntity buildProductEntity(Product product) {
    ProductEntity productEntity = new ProductEntity();
    productEntity.setImage(product.getImage());
    productEntity.setName(product.getName());
    productEntity.setPrice(product.getPrice());
    productEntity.setProductId(product.getId());
    productEntity.setCategory(product.getCategory());
    return productEntity;
  }

  @Override
  public Product createDummyProduct() throws ValidationException {
    Product product = new Product();
    long id = ThreadLocalRandom.current().nextLong(1, 99999);
    product.setId(id);
    product.setCategory("dummy" + id);

    double price = ThreadLocalRandom.current().nextDouble(1, 99999);
    product.setPrice(price);
    product.setName("dummy" + price);

    this.createProduct(product);
    return product;
  }
}
