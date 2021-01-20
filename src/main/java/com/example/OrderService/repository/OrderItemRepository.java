package com.example.OrderService.repository;

import com.example.OrderService.domain.InventoryData;
import com.example.OrderService.entity.Order;
import com.example.OrderService.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,String> {
    @Transactional
    @Modifying
    @Query(value="select order_id from orders where user_id=:userId",nativeQuery = true)
    List<String> findOrderIdsByUserId(@Param("userId") String userId);

    @Transactional
    @Modifying
    @Query(value="SELECT * from orderitem p where p.order_id in :orderids",nativeQuery=true)
    List<OrderItem> getOrderItems(@Param("orderids") List<String> orderids);

    List<OrderItem> findByMerchantId(String merchantId);

    @Transactional
    @Modifying
    @Query(value = "update orderitem set rating=:rating where order_item_id=:orderItemId",nativeQuery = true)
    void updateOrderItemRating(@Param("orderItemId")String orderItem,@Param("rating") double rating);

    @Transactional
    @Query(value="select count(order_item_id) from orderitem where merchant_id=:merchant_id group by merchant_id ",nativeQuery = true)
    int findCountOfOrderItemByMerhcant_id(@Param("merchant_id") String merchant);

    @Transactional
    @Query(value="select avg(rating) from orderitem where merchant_id=:merchant_id group by merchant_id",nativeQuery = true)
    double setMerchantRating(@Param("merchant_id") String merchantId);

    @Transactional
    @Query(value="select * from orderitem order by rating   desc limit 5",nativeQuery = true)
    List<OrderItem> getRecommendation();

}
