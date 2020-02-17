package com.kadircemtuna.challenge.productshippingservice.dto;

public class ProductOrder {
  private Long productOrderId;
  private String saleCode;
  private Product product;

  public Long getProductOrderId() {
    return productOrderId;
  }

  public void setProductOrderId(Long productOrderId) {
    this.productOrderId = productOrderId;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
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
        ", productId:" + product.getId() +
        '}';
  }
}
