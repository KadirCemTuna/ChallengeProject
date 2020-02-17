package com.kadircemtuna.challenge.productsaleservice.entity;

import javax.persistence.*;

@Table(name = "productOrder")
@Entity
public class ProductOrderEntity {
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long productOrderId;
  @Column(name = "productId")
  private Long productId;
  @Column(name = "saleCode")
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
