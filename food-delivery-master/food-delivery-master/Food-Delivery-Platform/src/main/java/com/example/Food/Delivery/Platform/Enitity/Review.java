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
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String targetType;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private DeliveryDriver driver;
}