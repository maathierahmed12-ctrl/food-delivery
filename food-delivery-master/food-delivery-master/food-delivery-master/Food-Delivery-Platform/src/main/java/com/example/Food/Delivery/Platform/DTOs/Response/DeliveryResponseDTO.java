package com.example.Food.Delivery.Platform.DTOs.Response;

import com.example.Food.Delivery.Platform.Enitity.Delivery;
import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryResponseDTO {

    private Integer id;

    private String trackingCode;

    private String status;

    private LocalDateTime assignedAt;

    private LocalDateTime pickedUpAt;

    private LocalDateTime deliveredAt;

    public static DeliveryResponseDTO toResponse(Delivery delivery) {
        DeliveryResponseDTO dto = new DeliveryResponseDTO();
        dto.setTrackingCode(delivery.getTrackingCode());
        dto.setStatus(delivery.getStatus());
        dto.setAssignedAt(delivery.getAssignedAt());
        dto.setPickedUpAt(delivery.getPickedUpAt());
        dto.setDeliveredAt(delivery.getDeliveredAt());

        return dto;

    }
}
