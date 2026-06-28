package com.example.Food.Delivery.Platform.DTOs.Response;

import com.example.Food.Delivery.Platform.DTOs.Summary.ComboMeal;
import com.example.Food.Delivery.Platform.Enitity.Customer;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ComboMealResponseDTO {

    private Long id;

    private String comboName;

    private String description;

    private Double totalPrice;

    private Boolean isAvailable;


    public static ComboMealResponseDTO toResponse(ComboMeal comboMeal) {

        ComboMealResponseDTO dto = new ComboMealResponseDTO();

        dto.setId(dto.getId());
        dto.setComboName(comboMeal.getComboName());
        dto.setDescription(dto.getDescription());
        dto.setTotalPrice(comboMeal.getTotalPrice());
        dto.setTotalPrice(comboMeal.getTotalPrice());
        dto.setIsAvailable(comboMeal.getIsAvailable());

        return dto;

    }

}



