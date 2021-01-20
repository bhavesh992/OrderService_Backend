package com.example.OrderService.repository;

import com.example.OrderService.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CartRepository extends JpaRepository<Cart,String> {

    @Transactional
    @Query(value="select cart_id from cart where user_id=:user_id",nativeQuery = true)
    String getCartIdByUserId(@Param("user_id") String user_id);

    @Transactional
    Cart findByUserId(String user_id);
}
