package com.example.Food.Delivery.Platform.Repositories;

import ch.qos.logback.core.status.Status;
import com.example.Food.Delivery.Platform.Enitity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findByOrderId(Integer orderId);

    List<Payment> findByCustomerId(Integer customerId);

    List<Payment> findByStatus(Status status);

    @Query("""
    SELECT p.processedAt, totalByPaymentMethod(p.amount)
    FROM Payment p
    GROUP BY p.processedAt
""")
    List<Object[]> totalByPaymentMethod();

    @Query("""
        SELECT COALESCE(SUM(p.amount), 0)
        FROM Payment p
        WHERE p.processedAt = 'COMPLETED'
    """)
    Double totalRevenue();

    @Query("""
        SELECT p FROM Payment p
        WHERE (:method IS NULL OR p.processedAt = :method)
        AND (:status IS NULL OR p.processedAt = :status)
        AND (:from IS NULL OR p.createdAt >= :from)
        AND (:to IS NULL OR p.createdAt <= :to)
    """)
    Page<Payment> filterPayments(
            @Param("method") Method method,
            @Param("status") Status status,
            @Param("from") LocalDate from,
            @Param("to") LocalDate to,
            Pageable pageable
    );
}





