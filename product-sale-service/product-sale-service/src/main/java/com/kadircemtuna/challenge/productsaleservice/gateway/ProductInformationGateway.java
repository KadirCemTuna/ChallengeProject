package com.kadircemtuna.challenge.productsaleservice.gateway;

import com.kadircemtuna.challenge.productsaleservice.dto.Product;

public interface ProductInformationGateway {

  Product inquireProduct(Long productId);
}
