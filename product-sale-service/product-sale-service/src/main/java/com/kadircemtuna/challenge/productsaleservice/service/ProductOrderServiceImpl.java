package com.kadircemtuna.challenge.productsaleservice.service;

import com.kadircemtuna.challenge.productsaleservice.dto.Product;
import com.kadircemtuna.challenge.productsaleservice.dto.ProductOrder;
import com.kadircemtuna.challenge.productsaleservice.dto.Shipment;
import com.kadircemtuna.challenge.productsaleservice.entity.ProductOrderEntity;
import com.kadircemtuna.challenge.productsaleservice.gateway.ProductInformationGateway;
import com.kadircemtuna.challenge.productsaleservice.gateway.ProductShipmentGateway;
import com.kadircemtuna.challenge.productsaleservice.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
  @Autowired
  private ProductOrderRepository productOrderRepository;
  @Autowired
  private ProductInformationGateway productInformationGateway;
  @Autowired
  private ProductShipmentGateway productShipmentGateway;

  @Override
  public void createProductOrder(List<Long> productIds) throws ValidationException {
    String saleCode = UUID.randomUUID().toString();

    this.validateProductOrder(productIds);
    productIds.stream()
        .map((Long id) -> buildProductOrderEntity(id, saleCode))
        .forEach(productOrderEntity -> this.productOrderRepository.save(productOrderEntity));
  }

  private ProductOrderEntity buildProductOrderEntity(Long id, String saleCode) {
    ProductOrderEntity productOrderEntity = new ProductOrderEntity();
    productOrderEntity.setProductId(id);
    productOrderEntity.setSaleCode(saleCode);
    return productOrderEntity;
  }

  private void validateProductOrder(List<Long> productIdList) throws ValidationException {
    if (CollectionUtils.isEmpty(productIdList)) {
      throw new ValidationException("validateProductOrder, there is no product in this order.");
    }
  }

  @Override
  public void createDummyProductOrder() throws ValidationException {
    List<Long> productIdList = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      long id = ThreadLocalRandom.current().nextLong(1, 10);
      productIdList.add(id);
    }
    this.createProductOrder(productIdList);
  }

  @Override
  public ProductOrder inquireProductOrder(Long orderId) {
    ProductOrderEntity productOrderEntity = this.productOrderRepository.findByProductOrderId(orderId);
    if (productOrderEntity != null) {
      List<ProductOrderEntity> productOrderEntities = this.productOrderRepository.findBySaleCode(productOrderEntity.getSaleCode());

      List<Product> productList = new ArrayList<>();
      for (ProductOrderEntity orderEntity : productOrderEntities) {
        Product product = this.productInformationGateway.inquireProduct(orderEntity.getProductId());
        productList.add(product);
      }

      if (!CollectionUtils.isEmpty(productList)) {
        return this.buildProductOffer(orderId, productOrderEntities, productList);
      }
    }
    return null;
  }

  private ProductOrder buildProductOffer(Long orderId, List<ProductOrderEntity> productOrderEntities, List<Product> productList) {
    ProductOrder productOrder = new ProductOrder();
    productOrder.setProduct(productList);

    String saleCode = productOrderEntities.stream()
        .map(ProductOrderEntity::getSaleCode)
        .findFirst()
        .orElse("");
    productOrder.setSaleCode(saleCode);

    List<Long> productIdList = productOrderEntities.stream()
        .map(ProductOrderEntity::getProductId)
        .collect(Collectors.toList());
    productOrder.setProductIdList(productIdList);

    productOrder.setProductOrderId(orderId);
    return productOrder;
  }

  @Override
  public Shipment inquireShipment(Long orderId) {
    return this.productShipmentGateway.inquireShipment(orderId);
  }
}
