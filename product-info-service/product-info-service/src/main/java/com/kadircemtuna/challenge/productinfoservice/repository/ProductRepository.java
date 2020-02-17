package com.kadircemtuna.challenge.productinfoservice.repository;

import com.kadircemtuna.challenge.productinfoservice.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
