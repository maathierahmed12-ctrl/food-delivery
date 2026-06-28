package com.example.Food.Delivery.Platform.DTOs.Response;

import com.example.Food.Delivery.Platform.DTOs.Request.RestaurantOwner;
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
public class RestaurantOwnerResponseDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String businessLicenseCode;


    public static RestaurantOwnerResponseDTO toResponse(RestaurantOwner restaurantOwner) {

        RestaurantOwnerResponseDTO dto = new RestaurantOwnerResponseDTO();

        dto.setFirstName(restaurantOwner.getFirstName());
        dto.setLastName(restaurantOwner.getLastName());
        dto.setEmail(restaurantOwner.getEmail());
        dto.setPhone(restaurantOwner.getPhone());
        dto.setBusinessLicenseCode(restaurantOwner.getBusinessLicenseCode());
        return dto;
    }

}