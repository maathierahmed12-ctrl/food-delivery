package com.example.Food.Delivery.Platform.DTOs.Request;

import com.example.Food.Delivery.Platform.Enitity.Restaurant;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantOwner {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String password;

    @NotBlank
    private String businessLicenseCode;

    public static RestaurantOwner toRestaurantOwner(RestaurantOwner restaurantOwner){

        RestaurantOwner restaurantOwnerDTO = new RestaurantOwner();
        restaurantOwnerDTO.setFirstName(restaurantOwner.getFirstName());
        restaurantOwnerDTO.setLastName(restaurantOwner.getLastName());
        restaurantOwnerDTO.setEmail(restaurantOwner.getEmail());
        restaurantOwnerDTO.setPhone(restaurantOwner.getPhone());
        restaurantOwnerDTO.setPassword(restaurantOwner.getPassword());
        restaurantOwnerDTO.setBusinessLicenseCode(restaurantOwner.getBusinessLicenseCode());
        return restaurantOwnerDTO;
    }
}

