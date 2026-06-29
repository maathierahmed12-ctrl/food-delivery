package com.example.Food.Delivery.Platform.DTOs.Summary;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Delivery {

    private  String trackingCode;

    private String status;

    private LocalDateTime deliveredAt;
}
