package com.kadircemtuna.challenge.productinfoservice.service;

import com.kadircemtuna.challenge.productinfoservice.common.GeneralEnumeration;
import com.kadircemtuna.challenge.productinfoservice.dto.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductInformationServiceImpl implements ProductInformationService {
  @Override
  public Product inquireProduct(Long productId) {

    return new Product(1L, GeneralEnumeration.ProductStatus.Active.name()
        , 123.5D, "Keyboard", "asddasd");
  }
}
