package com.kadircemtuna.challenge.productsaleservice.entity;

public class ProductOrderEntity {
  private Long productOrderId;
  private Long productId;
  private String saleCode;

  public Long getProductOrderId() {
    return productOrderId;
  }

  public void setProductOrderId(Long productOrderId) {
    this.productOrderId = productOrderId;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getSaleCode() {
    return saleCode;
  }

  public void setSaleCode(String saleCode) {
    this.saleCode = saleCode;
  }
}
