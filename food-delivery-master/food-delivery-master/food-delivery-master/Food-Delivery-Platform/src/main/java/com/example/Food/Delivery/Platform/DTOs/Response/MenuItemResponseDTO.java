package com.example.Food.Delivery.Platform.DTOs.Response;
import com.example.Food.Delivery.Platform.Enitity.Delivery;
import com.example.Food.Delivery.Platform.Enitity.MenuItem;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MenuItemResponseDTO {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private Boolean isAvailable;

    private Boolean isVegetarian;

    private Integer calories;


    public static MenuItemResponseDTO toResponse(MenuItem menuItem) {

        MenuItemResponseDTO dto = new MenuItemResponseDTO();

        dto.setName(menuItem.getName());
        dto.setDescription(menuItem.getDescription());
        dto.setPrice(menuItem.getPrice());
        dto.setIsAvailable(menuItem.isAvailable());
        dto.setIsVegetarian(menuItem.isVegetarian());
        dto.setCalories(menuItem.getCalories());
        return dto;

    }

}


