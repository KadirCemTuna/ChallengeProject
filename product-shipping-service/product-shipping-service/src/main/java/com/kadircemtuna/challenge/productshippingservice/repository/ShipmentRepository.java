package com.kadircemtuna.challenge.productshippingservice.repository;

import com.kadircemtuna.challenge.productshippingservice.entity.ShipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ShipmentRepository extends JpaRepository<ShipmentEntity, Long> {
  ShipmentEntity findBySaleId(Long saleId);
}
