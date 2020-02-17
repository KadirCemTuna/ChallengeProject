package com.kadircemtuna.challenge.productsaleservice.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "productOrder")
@Entity
public class ProductOrderEntity implements Serializable {
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  @Column(name = "productOrderId")
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
