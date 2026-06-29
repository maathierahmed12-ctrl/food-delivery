package com.example.Food.Delivery.Platform.DTOs.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComboMeal {


    @NotBlank
    private String comboName;

    private String description;

    @NotNull
    @Positive
    private Double totalPrice;

    private Boolean isAvailable = true;
}


