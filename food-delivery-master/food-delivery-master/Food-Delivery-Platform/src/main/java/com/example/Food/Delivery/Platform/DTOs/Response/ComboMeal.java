package com.example.Food.Delivery.Platform.DTOs.Response;

import lombok.*;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ComboMeal {

    private Long id;

    private String comboName;

    private String description;

    private Double totalPrice;

    private Boolean isAvailable;
}




