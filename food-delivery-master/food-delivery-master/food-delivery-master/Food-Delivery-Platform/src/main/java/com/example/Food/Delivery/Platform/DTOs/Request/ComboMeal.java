package com.example.Food.Delivery.Platform.DTOs.Request;
import com.example.Food.Delivery.Platform.DTOs.Response.ComboMealResponseDTO;
import com.example.Food.Delivery.Platform.Enitity.Customer;
import com.example.Food.Delivery.Platform.Enitity.CustomerAddress;
import com.example.Food.Delivery.Platform.Utils.HelperUtils;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComboMeal {


    @NotBlank
    private String comboName;

    private String description;

    @NotNull
    @Positive
    private Double totalPrice;

    @Builder.Default
    private Boolean isAvailable = true;

    public static ComboMeal toRequest(ComboMealResponseDTO dto) {
        ComboMeal comboMeal = new ComboMeal();

        comboMeal.setComboName(dto.getComboName());
        comboMeal.setDescription(dto.getDescription());
        comboMeal.setTotalPrice(dto.getTotalPrice());
        comboMeal.isAvailable = dto.getIsAvailable();


        return comboMeal;
    }
}


