package com.ecommerce.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

  private long id;
  private Integer shop_id;
  private String category;
  private String name;
  private String flavor;
  private Integer quantity;
  private Float price_per;


  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }

  public Integer getShopId() {
    return shop_id;
  }
  
  public void setShopId(Integer shop_id) {
    this.shop_id = shop_id;
  }

  public String getCategory() {
    return category;
  }

  public String getName() {
    return name;
  }

  public String getFlavor() {
    return flavor;
  }

  public Integer getQuantity () {
    return quantity;
  }

  public void setQuantity (Integer quantity) {
    this.quantity = quantity;
  }

  public Float getPrice() {
      return price_per;
  }

  public void setPrice(Float price_per) {
      this.price_per = price_per;
  }

}
