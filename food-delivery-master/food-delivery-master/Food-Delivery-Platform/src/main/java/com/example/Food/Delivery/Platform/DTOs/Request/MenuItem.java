package com.example.Food.Delivery.Platform.DTOs.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class MenuItem {

    @NotBlank
    private String name;

    private String description;

    @NotNull
    @Positive
    private Double price;

    private Boolean isAvailable = true;

    private Boolean isVegetarian = false;

    private Integer calories;
}

