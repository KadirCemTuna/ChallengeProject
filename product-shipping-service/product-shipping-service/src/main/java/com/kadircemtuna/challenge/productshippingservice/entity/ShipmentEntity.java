package com.kadircemtuna.challenge.productshippingservice.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "shipment")
@Entity
public class ShipmentEntity {
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long saleId;
  private String status;
  private Date createdAt;

  public Long getSaleId() {
    return saleId;
  }

  public void setSaleId(Long saleId) {
    this.saleId = saleId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}
