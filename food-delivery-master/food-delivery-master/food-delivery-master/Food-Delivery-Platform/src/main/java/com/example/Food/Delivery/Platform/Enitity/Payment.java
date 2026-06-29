package com.example.Food.Delivery.Platform.Enitity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String PaymentMethod ;
    private String PaymentStatus ;
    private LocalDateTime createdAt;

    private double amount;
    private String transactionRef;

    private LocalDateTime processedAt;

    @OneToOne
    private Order order;


}
