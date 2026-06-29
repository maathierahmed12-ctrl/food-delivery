package com.example.Food.Delivery.Platform.DTOs.Request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Delivery {

    private String trackingCode;

    private String status;

    private Long deliveryDriverId;
}
