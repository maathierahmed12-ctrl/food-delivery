package com.example.Food.Delivery.Platform.Enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentMethod;
    private String status;

    private double amount;
    private String transactionRef;

    private LocalDateTime processedAt;

    @OneToOne
    private Order order;


}
