package com.example.Food.Delivery.Platform.DTOs.Response;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MenuItem {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private Boolean isAvailable;

    private Boolean isVegetarian;

    private Integer calories;
}


