package com.ecommerce.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Net {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

  private long id;
  private Integer shop_id;
  private Float net;


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

  public Float getNet() {
      return net;
  }

  public void setNet(Float net) {
      this.net = net;
  }

}