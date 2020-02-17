package com.kadircemtuna.challenge.productsaleservice.repository;

import com.kadircemtuna.challenge.productsaleservice.entity.ProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductOrderRepository extends JpaRepository<ProductOrderEntity, Long> {
  List<ProductOrderEntity> findByProductOrderId(Long id);
}
