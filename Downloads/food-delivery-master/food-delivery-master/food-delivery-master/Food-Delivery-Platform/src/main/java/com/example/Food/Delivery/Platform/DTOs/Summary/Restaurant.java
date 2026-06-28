package com.example.Food.Delivery.Platform.DTOs.Summary;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Restaurant {

    private String name;

    private String description;

    private String cuisineType;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private BigDecimal minOrderAmount;

    private BigDecimal deliveryFee;

    private Boolean acceptingOrders;
}

