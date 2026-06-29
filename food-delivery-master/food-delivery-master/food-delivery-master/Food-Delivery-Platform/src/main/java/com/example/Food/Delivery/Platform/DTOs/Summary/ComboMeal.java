package com.example.Food.Delivery.Platform.DTOs.Summary;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class ComboMeal {


    private String comboName;

    private Double totalPrice;

    private Boolean isAvailable;

    public static ComboMeal toSummary(ComboMeal comboMeal) {
        ComboMeal dto = new ComboMeal();

        dto.setComboName(comboMeal.getComboName());
        dto.setTotalPrice(comboMeal.getTotalPrice());

        return dto;
    }
}


