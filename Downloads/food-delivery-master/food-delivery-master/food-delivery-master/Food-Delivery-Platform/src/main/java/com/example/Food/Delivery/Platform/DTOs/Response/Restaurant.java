package com.example.Food.Delivery.Platform.DTOs.Response;

import com.example.Food.Delivery.Platform.Enitity.Payment;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;
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
public class Restaurant {

    private Long id;

    private String name;

    private String description;

    private String cuisineType;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private BigDecimal minOrderAmount;

    private BigDecimal deliveryFee;

    private Boolean acceptingOrders;

    public static Restaurant toResponse(Restaurant restaurant) {
        Restaurant dto = new Restaurant();

        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());
        dto.setDescription(restaurant.getDescription());
        dto.setCuisineType(restaurant.getCuisineType());
        dto.setOpeningTime(restaurant.getOpeningTime());
        dto.setClosingTime(restaurant.getClosingTime());
        dto.setMinOrderAmount(restaurant.getMinOrderAmount());
        dto.setDeliveryFee(restaurant.getDeliveryFee());
        dto.setAcceptingOrders(restaurant.getAcceptingOrders());

        return dto;
    }
}