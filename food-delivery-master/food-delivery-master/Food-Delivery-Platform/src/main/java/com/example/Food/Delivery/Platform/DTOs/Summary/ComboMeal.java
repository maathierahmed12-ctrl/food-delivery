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

}
