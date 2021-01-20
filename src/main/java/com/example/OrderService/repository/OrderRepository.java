package com.example.OrderService.repository;

import com.example.OrderService.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {
    @Transactional
    @Query(value="select order_id from orders where user_id=:userId",nativeQuery = true)
    List<String> findByUserId(@Param("userId") String userId);


}
