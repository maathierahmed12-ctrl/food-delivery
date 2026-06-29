package com.example.Food.Delivery.Platform.DTOs.Summary;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Order {

    private String orderCode;

    private LocalDateTime orderDate;

    private String status;

    private BigDecimal totalAmount;
}

