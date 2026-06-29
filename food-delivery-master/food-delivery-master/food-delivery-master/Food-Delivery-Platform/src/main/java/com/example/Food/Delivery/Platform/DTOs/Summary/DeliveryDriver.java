package com.example.Food.Delivery.Platform.DTOs.Summary;

import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryDriver {

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String driverCode;

    private String vehicleType;

    private String vehiclePlate;

    private Double currentLat;

    private Double currentLng;

    private Boolean isOnline;
}

