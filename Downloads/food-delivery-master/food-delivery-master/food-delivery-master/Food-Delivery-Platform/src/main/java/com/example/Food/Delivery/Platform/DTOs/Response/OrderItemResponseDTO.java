package com.example.Food.Delivery.Platform.DTOs.Response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class OrderItemResponseDTO {

    private Long id;

    private Integer quantity;

    private Double unitPrice;

    private Double totalPrice;

    private String specialInstructions;
}

