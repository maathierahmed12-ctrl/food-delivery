package com.example.Food.Delivery.Platform.DTOs.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDriver {

    @NotBlank
    private String firstName;

    @NotBlank
    private  String lastName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String password;

    private String driverCode;

    @NotBlank
    private String vehicleType;
    @NotBlank
    private String vehiclePlate;

    private String currentLat;

    private String currentLng;

    private Boolean isOnline;
}
