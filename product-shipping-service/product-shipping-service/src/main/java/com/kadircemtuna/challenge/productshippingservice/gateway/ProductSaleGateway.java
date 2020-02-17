package com.kadircemtuna.challenge.productshippingservice.gateway;

import com.kadircemtuna.challenge.productshippingservice.dto.ProductOrder;

public interface ProductSaleGateway {
  ProductOrder inquireProductOrder(Long orderId);
}
