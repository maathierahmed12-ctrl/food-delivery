package com.example.Food.Delivery.Platform.Enitity;
import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String orderCode;

    private LocalDateTime orderDate;

    private String status;

    private LocalDateTime changedAt;

    private double subtotal;
    private double deliveryFee;
    private double discountAmount;
    private double totalAmount;

    private String note;
    private String deliveryNotes;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Restaurant restaurant;

    @OneToMany
    private List<OrderItem> orderItems;

    @OneToOne
    private Delivery delivery;

    @OneToOne
    private Payment payment;

}