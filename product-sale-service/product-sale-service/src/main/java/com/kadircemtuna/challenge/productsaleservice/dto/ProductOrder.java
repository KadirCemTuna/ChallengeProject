package com.kadircemtuna.challenge.productsaleservice.dto;

import java.util.List;

public class ProductOrder {
  private Long productOrderId;
  private String saleCode;
  private Long productId;
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

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
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
        ", productId:" + productId +
        ", product:" + product +
        '}';
  }
}
