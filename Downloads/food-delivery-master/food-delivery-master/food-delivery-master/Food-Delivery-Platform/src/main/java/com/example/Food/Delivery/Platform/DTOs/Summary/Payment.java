package com.example.Food.Delivery.Platform.DTOs.Summary;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
 public class Payment {

    private String paymentMethod;

    private Double amount;

    private String status;
}