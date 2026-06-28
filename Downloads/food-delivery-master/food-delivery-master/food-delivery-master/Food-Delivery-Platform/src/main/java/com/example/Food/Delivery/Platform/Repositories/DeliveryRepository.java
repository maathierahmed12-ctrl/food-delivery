package com.example.Food.Delivery.Platform.Repositories;
import com.example.Food.Delivery.Platform.Enitity.Delivery;
import com.example.Food.Delivery.Platform.Enitity.DeliveryDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Driver;
import java.time.LocalDateTime;
import java.util.List;

@Repository

public interface DeliveryRepository extends JpaRepository<Driver, Long> {


        @Query("""
    SELECT d FROM Delivery d
    WHERE d.customer.id = :customerId
    AND d.isActive = true
    """)
        List<Delivery> findByCustomerId(@Param("customerId") Integer customerId);

        @Query("""
    SELECT d FROM Delivery d
    WHERE d.restaurant.id = :restaurantId
    AND d.status = :status
    AND d.isActive = true
    """)
        List<Delivery> findByRestaurantIdAndStatus(
                @Param("restaurantId") Integer restaurantId, @Param("status") String status);

        @Query("""
    SELECT d FROM Delivery d
    WHERE d.orderDate BETWEEN :start AND :end
    AND d.isActive = true
    """)
        List<Delivery> findByOrderDateBetween(
                @Param("start") LocalDateTime start,
                @Param("end") LocalDateTime end
        );

        @Query("""
    SELECT d FROM Delivery d
    WHERE d.deliveryDriver.id = :driverId
    AND d.status = :status
    AND d.isActive = true
    """)
        List<Delivery> findByDeliveryDriverIdAndStatus(
                @Param("driverId") Integer driverId,
                @Param("status") String status
        );
        List<Delivery> findByDriverIdAndStatus(Long driverId, String status);


        @Query("""
        SELECT d
        FROM DeliveryDriver d
        WHERE d.isOnline = true
        AND d.isAvailable = true
        AND (
            6371 * acos(
                cos(radians(:lat)) *
                cos(radians(d.latitude)) *
                cos(radians(d.longitude) - radians(:lng)) +
                sin(radians(:lat)) *
                sin(radians(d.latitude))
            )
        ) <= :radiusKm
    """)
        List<DeliveryDriver> findNearbyDrivers(
                @Param("lat") double lat,
                @Param("lng") double lng,
                @Param("radiusKm") double radiusKm
        );

        @Query("""
        SELECT
            COUNT(o),
            AVG(o.deliveryTime),
            AVG(r.rating)
        FROM Order o
        LEFT JOIN Review r ON r.order.id = o.id
        WHERE o.driver.id = :driverId
    """)
        List<Delivery> getDriverPerformance(@Param("driverId") Long driverId);
        List<Delivery>findByDriverId(Long Driver);

}


