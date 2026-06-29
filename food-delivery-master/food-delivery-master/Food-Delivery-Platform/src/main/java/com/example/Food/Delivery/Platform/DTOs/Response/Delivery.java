package com.example.Food.Delivery.Platform.DTOs.Response;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    private Long id;

    private String trackingCode;

    private String status;

    private LocalDateTime assignedAt;

    private LocalDateTime pickedUpAt;

    private LocalDateTime deliveredAt;
}
