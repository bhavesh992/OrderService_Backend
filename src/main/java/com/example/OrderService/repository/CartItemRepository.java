package com.example.OrderService.repository;

import com.example.OrderService.entity.Cart;
import com.example.OrderService.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,String> {

    @Transactional
    @Modifying
   void deleteByCart(Cart cart);

    @Transactional
    @Modifying
    @Query(value ="select * from cartitem where cart_id=:cartId",nativeQuery = true)
    List<CartItem> getCartItemsByCartId(@Param("cartId") String cartId);
}
