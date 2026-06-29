package com.example.Food.Delivery.Platform.Enitity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderCode;
    private LocalDateTime orderDate;
    private String status;

    private double subtotal;
    private double deliveryFee;
    private double discountAmount;
    private double totalAmount;
    private String Note;
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