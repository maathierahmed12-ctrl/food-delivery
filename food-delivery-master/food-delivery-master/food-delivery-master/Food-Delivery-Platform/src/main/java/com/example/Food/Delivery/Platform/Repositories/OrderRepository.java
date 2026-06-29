package com.example.Food.Delivery.Platform.Repositories;
import com.example.Food.Delivery.Platform.Enitity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("""
        SELECT o FROM Order o
        WHERE o.customer.id = :customerId
    """)
    List<Order> findByCustomerId(@Param("customerId") Integer customerId);

    @Query("""
        SELECT o FROM Order o
        WHERE o.customer.id = :customerId
        AND (:status IS NULL OR o.status = :status)
        AND (:from IS NULL OR o.orderDate >= :from)
        AND (:to IS NULL OR o.orderDate <= :to)
    """)
    Page<Order> filterCustomerOrders(
            @Param("customerId") Integer customerId,
            @Param("status") String status,
            @Param("from") LocalDate from,
            @Param("to") LocalDate to,
            Pageable pageable
    );
}