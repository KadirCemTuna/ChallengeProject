package com.kadircemtuna.challenge.productsaleservice.common;

import java.util.List;

public class CreateProductOrderRequest {
  private List<Long> productIdList;

  public List<Long> getProductIdList() {
    return productIdList;
  }

  public void setProductIdList(List<Long> productIdList) {
    this.productIdList = productIdList;
  }
}
