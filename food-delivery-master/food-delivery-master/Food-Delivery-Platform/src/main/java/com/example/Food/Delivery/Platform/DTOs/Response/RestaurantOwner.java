package com.example.Food.Delivery.Platform.DTOs.Response;

import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RestaurantOwner {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String businessLicenseCode;
}

