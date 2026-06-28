package com.example.Food.Delivery.Platform.DTOs.Response;

import com.example.Food.Delivery.Platform.DTOs.Summary.DeliveryDriver;
import com.example.Food.Delivery.Platform.Enitity.Customer;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class DeliveryDriverResponse {

    private Long id;

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


    public static DeliveryDriverResponse toResponse(DeliveryDriver deliveryDriver) {

        DeliveryDriverResponse dto = new DeliveryDriverResponse();

        dto.setPhone(deliveryDriver.getPhone());
        dto.setDriverCode(deliveryDriver.getDriverCode());
        dto.setVehicleType(deliveryDriver.getVehicleType());
        dto.setVehiclePlate(deliveryDriver.getVehiclePlate());
        dto.setCurrentLat(deliveryDriver.getCurrentLat());
        dto.setCurrentLng(deliveryDriver.getCurrentLng());
        dto.setIsOnline(deliveryDriver.getIsOnline());
        return dto;
    }
}
