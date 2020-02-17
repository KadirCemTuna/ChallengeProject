package com.kadircemtuna.challenge.productinfoservice.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "product")
@Entity
public class ProductEntity implements Serializable {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long productId;
  @Column(name = "category")
  private String category;
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

  public String getCategory() {
    return category;
  }

  public void setCategory(String status) {
    this.category = status;
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
        ", status:'" + category + '\'' +
        ", price:" + price +
        ", name:'" + name + '\'' +
        ", image:'" + image + '\'' +
        '}';
  }
}
