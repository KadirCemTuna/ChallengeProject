package com.kadircemtuna.challenge.productshippingservice.dto;

import java.util.List;

public class ProductOrder {
  private Long productOrderId;
  private String saleCode;
  private List<Long> productIdList;
  private List<Product> product;

  public Long getProductOrderId() {
    return productOrderId;
  }

  public void setProductOrderId(Long productOrderId) {
    this.productOrderId = productOrderId;
  }

  public String getSaleCode() {
    return saleCode;
  }

  public void setSaleCode(String saleCode) {
    this.saleCode = saleCode;
  }

  public List<Long> getProductIdList() {
    return productIdList;
  }

  public void setProductIdList(List<Long> productIdList) {
    this.productIdList = productIdList;
  }

  public List<Product> getProduct() {
    return product;
  }

  public void setProduct(List<Product> product) {
    this.product = product;
  }

  @Override
  public String toString() {
    return "{" +
        "productOrderId:" + productOrderId +
        ", saleCode:'" + saleCode + '\'' +
        ", productIdList:" + productIdList +
        ", product:" + product +
        '}';
  }
}
