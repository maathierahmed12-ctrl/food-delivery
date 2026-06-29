package com.example.Food.Delivery.Platform.DTOs.Request;

import com.example.Food.Delivery.Platform.DTOs.Response.Restaurant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalTime;

@Data
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RestaurantRequestDTO {

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private String cuisineType;

    @NotNull
    private LocalTime openingTime;

    @NotNull
    private LocalTime closingTime;

    @NotNull
    @PositiveOrZero
    private Double minOrderAmount;

    @NotNull
    @PositiveOrZero
    private Double deliveryFee;

    private Boolean acceptingOrders = true;

    public static RestaurantRequestDTO toRequest(Restaurant restaurant) {

        RestaurantRequestDTO restaurantRequestDTO = new RestaurantRequestDTO();

        restaurantRequestDTO.setName(restaurant.getName());
        restaurantRequestDTO.setDescription(restaurant.getDescription());
        restaurantRequestDTO.setCuisineType(restaurant.getCuisineType());
        restaurantRequestDTO.setOpeningTime(restaurant.getOpeningTime());
        restaurantRequestDTO.setClosingTime(restaurant.getClosingTime());
        restaurantRequestDTO.setAcceptingOrders(restaurant.getAcceptingOrders());
        return restaurantRequestDTO;
    }
}






