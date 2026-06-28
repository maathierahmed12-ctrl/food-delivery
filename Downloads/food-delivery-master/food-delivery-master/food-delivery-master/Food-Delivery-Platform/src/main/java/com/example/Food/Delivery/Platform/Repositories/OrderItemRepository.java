package com.example.Food.Delivery.Platform.Repositories;

import com.example.Food.Delivery.Platform.Enitity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    @Query("SELECT o FROM OrderItem o " +
            "JOIN o.corporateOrder co " +
            "JOIN co.customer c " +
            "WHERE c.id = :customerId")
    List<OrderItem> findByCustomerId(@Param("customerId") Long customerId);

}