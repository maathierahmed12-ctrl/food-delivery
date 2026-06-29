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

    public static MenuItem toRequest(MenuItem menuItem) {

        MenuItem item = new MenuItem();
        item.setName(menuItem.getName());
        item.setDescription(menuItem.getDescription());
        item.setPrice(menuItem.getPrice());
        item.setIsAvailable(menuItem.getIsAvailable());
        item.setIsVegetarian(menuItem.getIsVegetarian());
        item.setCalories(menuItem.getCalories());
        return item;
    }
}

