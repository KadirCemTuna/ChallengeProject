package com.kadircemtuna.challenge.productsaleservice.dto;

public class Product {
  private Long id;
  private String status;
  private Double price;
  private String name;
  private String image;

  public Product() {
  }

  public Product(Long id, String status, Double price, String name, String image) {
    this.id = id;
    this.status = status;
    this.price = price;
    this.name = name;
    this.image = image;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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


}