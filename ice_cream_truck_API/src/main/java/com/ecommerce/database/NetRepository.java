package com.ecommerce.database;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface NetRepository extends JpaRepository<Net, Long> {

    @Modifying
    @Transactional
    @Query("update Net n set n.net = n.net + ?1 where n.shop_id = ?2")
    void updateNet(Float thisNet, Integer shop_id);

    @Query("select n.net FROM Net n where n.shop_id = ?1")
    Float getNet(Integer shop_id);
}
