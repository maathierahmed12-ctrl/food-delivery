package com.example.Food.Delivery.Platform.DTOs.Response;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorporateOrderItem {

    private Long id;

    private Integer quantity;

    private Double unitPrice;

    private Double totalPrice;

    private String specialInstructions;
}
