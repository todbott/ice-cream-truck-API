package com.ecommerce.database;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Transactional
    @Query("select i from Item i where i.shop_id = ?1")
    Iterable<Item> checkInventory(Integer shop_id);

    @Modifying
    @Transactional
    @Query("update Item i set i.quantity = i.quantity + ?1 where i.category = ?2 and i.name = ?3 and i.flavor = ?4 and i.shop_id = ?5")
    int addInventory(Integer quantity, String category, String name, String flavor, Integer shop_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO item (shop_id, category, name, flavor, quantity, price_per) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    int addItem(Integer shop_id, String category, String name, String flavor, Integer quantity, Float price);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM item WHERE shop_id = ?1 and category = ?2 and name = ?3 and flavor = ?4", nativeQuery = true)
    int deleteItem(Integer shop_id, String category, String name, String flavor);

    @Modifying
    @Transactional
    @Query("update Item i set i.price_per = ?1 where i.category = ?2 and i.name = ?3 and i.flavor = ?4 and i.shop_id = ?5")
    int changePrice(Float price, String category, String name, String flavor, Integer shop_id);

    @Query("select i.quantity FROM Item i where i.category = ?1 and i.name = ?2 and i.flavor = ?3 and i.shop_id = ?4")
    Integer countItems(String category, String name, String flavor, Integer shop_id);

    @Query("select i.price_per FROM Item i where i.category = ?1 and i.name = ?2 and i.flavor = ?3 and i.shop_id = ?4")
    Float getPrice(String category, String name, String flavor, Integer shop_id);

    @Modifying
    @Transactional
    @Query("update Item i set i.quantity = i.quantity - ?1 where i.category = ?2 and i.name = ?3 and i.flavor = ?4 and i.shop_id = ?5")
    void buy(Integer quantity, String category, String name, String flavor, Integer shop_id);

}
