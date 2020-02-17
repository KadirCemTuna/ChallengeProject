package com.kadircemtuna.challenge.productshippingservice.common;

public class CreateShipmentRequest {
  private Long saleId;
  private String status;

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
}
