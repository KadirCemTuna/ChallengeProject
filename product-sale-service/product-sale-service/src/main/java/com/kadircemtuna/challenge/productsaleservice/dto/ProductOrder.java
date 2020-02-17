package com.kadircemtuna.challenge.productsaleservice.dto;

public class ProductOrder {
  private Long productOrderId;
  private String saleCode;
  private Long productId;

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

  @Override
  public String toString() {
    return "{" +
        "productOrderId:" + productOrderId +
        ", saleCode:'" + saleCode + '\'' +
        ", productId:" + productId +
        '}';
  }
}
