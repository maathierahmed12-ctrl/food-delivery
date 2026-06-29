package com.example.Food.Delivery.Platform.DTOs.Response;

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

    private Long id;

    private String orderCode;

    private LocalDateTime orderDate;

    private String status;

    private BigDecimal subtotal;

    private BigDecimal deliveryFee;

    private BigDecimal discountAmount;

    private BigDecimal totalAmount;

    private String deliveryNotes;

}