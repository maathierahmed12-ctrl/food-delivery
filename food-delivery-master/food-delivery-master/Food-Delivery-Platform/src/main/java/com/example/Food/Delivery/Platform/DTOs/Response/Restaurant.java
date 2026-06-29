package com.example.Food.Delivery.Platform.DTOs.Response;

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
}


