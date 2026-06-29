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

public class RestaurantOwner {

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String businessLicenseCode;
}

