package com.example.Food.Delivery.Platform.DTOs.Summary;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MenuItem {

    private String name;

    private Double price;

    private Boolean isAvailable;

    private Boolean isVegetarian;
}