package com.example.Food.Delivery.Platform.Repositories;
import com.example.Food.Delivery.Platform.DTOs.Response.MenuItem;
import com.example.Food.Delivery.Platform.DTOs.Response.Order;
import com.example.Food.Delivery.Platform.Enitity.Customer;
import com.example.Food.Delivery.Platform.Enitity.CustomerAddress;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Integer> {

    @Query("""
SELECT a
FROM CustomerAddress a
WHERE LOWER(a.city) = LOWER(:city)
""")
    List<CustomerAddress> findByCity(@Param("city") String city);

    @Query("""
SELECT DISTINCT c
FROM Customer c
JOIN c.addresses a
WHERE LOWER(a.city) = LOWER(:city)
""")
    List<Customer> findCustomersByCity(@Param("city") String city);

    @Data
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class orderItemRepository {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private int quantity;

        private BigDecimal unitPrice;

        private BigDecimal totalPrice;

        private String specialInstructions;

        @ManyToOne
        private Order order;

        @ManyToOne
        private MenuItem menuItem;
    }
}