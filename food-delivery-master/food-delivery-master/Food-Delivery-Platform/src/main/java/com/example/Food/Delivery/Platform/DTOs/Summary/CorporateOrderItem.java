package com.example.Food.Delivery.Platform.DTOs.Summary;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class CorporateOrderItem {

    private Integer quantity;

    private Double totalPrice;

    private String specialInstructions;
}
