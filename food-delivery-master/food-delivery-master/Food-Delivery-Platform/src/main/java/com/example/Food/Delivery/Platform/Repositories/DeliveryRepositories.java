package com.example.Food.Delivery.Platform.Repositories;
import com.example.Food.Delivery.Platform.Enitity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Driver;
import java.time.LocalDateTime;
import java.util.List;

public interface DeliveryRepositories extends JpaRepository<Driver, Long> {


    @Query("""
    SELECT D FROM Delivery d
    WHERE D.customer.id = :customerId
    AND D.isActive = true
    """)
    List<Delivery> findByCustomerId(@Param("customerId") Integer customerId);

    @Query("""
SELECT D FROM Delivery d
    WHERE D.restaurant.id = :restaurantId
    AND D.status = :status
    AND D.isActive = true
    """)
    List<Delivery> findByRestaurantIdAndStatus(
            @Param("restaurantId") Integer restaurantId, @Param("status") String status);

    @Query("""
    SELECT D FROM Delivery D
    WHERE D.orderDate BETWEEN :start AND :end
    AND D.isActive = true
    """)
    List<Delivery> findByOrderDateBetween(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    @Query("""
    SELECT D FROM Delivery D
    WHERE D.deliveryDriver.id = :driverId
    AND D.status = :status
    AND D.isActive = true
    """)
    List<Delivery> findByDeliveryDriverIdAndStatus(
            @Param("driverId") Integer driverId,
            @Param("status") String status
    );
}


