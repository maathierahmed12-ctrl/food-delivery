package com.example.Food.Delivery.Platform.Repositories;
import com.example.Food.Delivery.Platform.Enitity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepositories extends JpaRepository<Order,Integer> {
    @Query("""
    SELECT o FROM Order o
    WHERE o.customer.id = :customerId
    """)
    List<Order> findByCustomerId(@Param("customerId") Long customerId); // تم التعديل إلى List<Order>


    @Query("""
    SELECT o FROM Order o
    WHERE o.restaurant.id = :restaurantId
    AND o.status = :status
    """)
    List<Order> findByRestaurantIdAndStatus(
            @Param("restaurantId") Long restaurantId,
            @Param("status") String status
    );


    @Query("""
    SELECT o FROM Order o
    WHERE o.orderDate BETWEEN :start AND :end
    """)
    List<Order> findByOrderDateBetween(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );


    @Query("""
    SELECT o FROM Order o
    WHERE o.delivery.id = :deliveryId
    AND o.status = :status
    """)
    List<Order> findByDeliveryIdAndStatus(
            @Param("deliveryId") Long deliveryId,
            @Param("status") String status
    );
}