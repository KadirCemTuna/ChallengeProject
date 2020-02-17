package com.kadircemtuna.challenge.productsaleservice.service;

import com.kadircemtuna.challenge.productsaleservice.dto.Product;
import com.kadircemtuna.challenge.productsaleservice.dto.ProductOrder;
import com.kadircemtuna.challenge.productsaleservice.entity.ProductOrderEntity;
import com.kadircemtuna.challenge.productsaleservice.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.ValidationException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
  @Autowired
  private ProductOrderRepository productOrderRepository;

  @Override
  public ProductOrder createProductOrder(ProductOrder productOrder) throws ValidationException {
    this.validateProductOrder(productOrder);
    ProductOrderEntity productOrderEntity = this.buildProductOrderEntity(productOrder);
    this.productOrderRepository.save(productOrderEntity);
    return null;
  }

  private ProductOrderEntity buildProductOrderEntity(ProductOrder productOrder) {
    ProductOrderEntity productOrderEntity = new ProductOrderEntity();
    productOrderEntity.setProductId(productOrder.getProductId());
    productOrderEntity.setProductOrderId(productOrder.getProductOrderId());
    productOrderEntity.setSaleCode(productOrder.getSaleCode());
    return productOrderEntity;
  }

  private void validateProductOrder(ProductOrder productOrder) throws ValidationException {
    if (productOrder.getProductOrderId() == null || productOrder.getProductOrderId() < 0L)
      throw new ValidationException("validateProductOrder, productOrderId is mandatory.");
    Optional<ProductOrderEntity> productOrderEntity = this.productOrderRepository.findById(productOrder.getProductOrderId());
    if (productOrderEntity.isPresent())
      throw new ValidationException("validateProductOrder, this id already exist.");
    if (productOrder.getSaleCode().isEmpty())
      throw new ValidationException("validateProductOrder, saleCode is mandatory.");
    if (productOrder.getProductId() == null || productOrder.getProductId() < 0L) {
      throw new ValidationException("validateProductOrder, there is no product in this order.");
    }
  }

  @Override
  public ProductOrder createDummyProductOrder() {
    return null;
  }

  @Override
  public ProductOrder inquireProductOrder(Long orderId) {


    RestTemplate restTemplate = new RestTemplate();
    Product template = restTemplate.getForObject("http://localhost:8080/product/" + orderId, Product.class);

    ProductOrder productOrder = new ProductOrder();
    productOrder.setProduct(template);
    productOrder.setSaleCode(UUID.randomUUID().toString());
    productOrder.setProductOrderId(123L);
    return productOrder;
  }
}
