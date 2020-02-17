package com.kadircemtuna.challenge.productinfoservice.entity;

public class ProductEntity {

  private Long productId;
  private String status;
  private Double price;
  private String name;
  private String image;

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  @Override
  public String toString() {
    return "{" +
        "id:" + productId +
        ", status:'" + status + '\'' +
        ", price:" + price +
        ", name:'" + name + '\'' +
        ", image:'" + image + '\'' +
        '}';
  }
}
