package com.example.Food.Delivery.Platform.DTOs.Response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Payment {

    private Long id;

    private String paymentMethod;

    private String status;

    private Double amount;

    private String transactionRef;

    private LocalDateTime processedAt;
}
