package com.example.Food.Delivery.Platform.Repositories;
import ch.qos.logback.core.status.Status;
import com.example.Food.Delivery.Platform.Enitity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("""
        SELECT o FROM Order o
        WHERE o.customer.id = :customerId
    """)
    List<Order> findByCustomerId(@Param("customerId") Long customerId);


    @Query("""
        SELECT o FROM Order o
        WHERE o.restaurant.id = :restaurantId
        AND o.status = :status
    """)
    List<Order> findByRestaurantIdAndStatus(
            @Param("restaurantId") Long restaurantId,
            @Param("status") Status status
    );

    @Query("""
        SELECT o FROM Order o
        WHERE o.orderDate BETWEEN :start AND :end
    """)
    List<Order> findByOrderDateBetween(
            @Param("start") LocalDate start,
            @Param("end") LocalDate end
    );


    @Query("""
        SELECT o FROM Order o
        WHERE o.delivery.id = :deliveryId
        AND o.status = :status
    """)
    List<Order> findByDeliveryIdAndStatus(
            @Param("deliveryId") Long deliveryId,
            @Param("status") Status status
    );

    @Query("""
        SELECT os
        FROM OrderStatusHistory os
        WHERE os.order.id = :orderId
        ORDER BY os.changedAt ASC
    """)
    List<Object> getOrderTimeline(@Param("orderId") Long orderId);


    @Query("""
        SELECT o FROM Order o
        WHERE o.customer.id = :customerId
        AND (:status IS NULL OR o.status = :status)
        AND (:from IS NULL OR o.orderDate >= :from)
        AND (:to IS NULL OR o.orderDate <= :to)
    """)
    Page<Order> filterCustomerOrders(
            @Param("customerId") Long customerId,
            @Param("status") Status status,
            @Param("from") LocalDate from,
            @Param("to") LocalDate to,
            Pageable pageable
    );


    @Query("""
        SELECT (6371 * acos(
            cos(radians(d.latitude)) *
            cos(radians(r.latitude)) *
            cos(radians(r.longitude) - radians(d.longitude)) +
            sin(radians(d.latitude)) *
            sin(radians(r.latitude))
        )) * 3
        FROM Order o
        JOIN o.driver d
        JOIN o.restaurant r
        WHERE o.id = :orderId
    """)
    Double calculateETA(@Param("orderId") Long orderId);

}