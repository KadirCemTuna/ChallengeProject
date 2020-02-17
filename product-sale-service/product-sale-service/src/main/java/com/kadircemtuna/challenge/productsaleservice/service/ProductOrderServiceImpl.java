package com.kadircemtuna.challenge.productsaleservice.service;

import com.kadircemtuna.challenge.productsaleservice.dto.Product;
import com.kadircemtuna.challenge.productsaleservice.dto.ProductOrder;
import com.kadircemtuna.challenge.productsaleservice.entity.ProductOrderEntity;
import com.kadircemtuna.challenge.productsaleservice.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
  @Autowired
  private ProductOrderRepository productOrderRepository;

  @Override
  public void createProductOrder(List<Long> productIdList) throws ValidationException {
    this.validateProductOrder(productIdList);
    List<Long> productIdList = productOrder.getProductIdList();
    productIdList.stream()
        .map(id -> this.buildProductOrderEntity(productOrder, id))
        .forEach(productOrderEntity -> this.productOrderRepository.save(productOrderEntity));
  }

  private ProductOrderEntity buildProductOrderEntity(ProductOrder productOrder, Long id) {
    ProductOrderEntity productOrderEntity = new ProductOrderEntity();
    productOrderEntity.setProductId(id);
    productOrderEntity.setProductOrderId(productOrder.getProductOrderId());
    productOrderEntity.setSaleCode(UUID.randomUUID().toString());
    return productOrderEntity;
  }

  private void validateProductOrder(List<Long> productIdList) throws ValidationException {
    Optional<ProductOrderEntity> productOrderEntity = this.productOrderRepository.findById(productOrder.getProductOrderId());
    if (productOrderEntity.isPresent())
      throw new ValidationException("validateProductOrder, this id already exist.");
    if (productOrder.getProductIdList().isEmpty()) {
      throw new ValidationException("validateProductOrder, there is no product in this order.");
    }
  }

  @Override
  public ProductOrder createDummyProductOrder() {
    return null;
  }

  @Override
  public ProductOrder inquireProductOrder(Long orderId) {
    if (orderId != null) {
      List<ProductOrderEntity> productOrderEntities = this.productOrderRepository.findByProductOrderId(orderId);
      List<Product> productList = new ArrayList<>();
      for (ProductOrderEntity productOrderEntity : productOrderEntities) {
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject("http://localhost:8080/product/" + orderId, Product.class);
        productList.add(product);
      }

      ProductOrder productOrder = new ProductOrder();
      productOrder.setProduct(productList);

      String saleCode = productOrderEntities.stream()
          .map(ProductOrderEntity::getSaleCode)
          .findFirst()
          .orElse("");
      productOrder.setSaleCode(saleCode);

      productOrder.setProductOrderId(orderId);
      return productOrder;
    }
    return null;
  }
}
