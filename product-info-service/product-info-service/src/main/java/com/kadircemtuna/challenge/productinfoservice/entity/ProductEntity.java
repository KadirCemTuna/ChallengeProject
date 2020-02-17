package com.kadircemtuna.challenge.productinfoservice.entity;

import javax.persistence.*;

@Table(name = "product")
@Entity
public class ProductEntity {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long productId;
  @Column(name = "status")
  private String status;
  @Column(name = "price")
  private Double price;
  @Column(name = "name")
  private String name;
  @Column(name = "image")
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
