package com.example.Food.Delivery.Platform.Enitity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Data

public class MenuItem extends BaseEntity{

    private String name;
    private String description;
    private double price;

    private boolean isAvailable;
    private boolean isVegetarian;
    private int calories;
    private String OrderCode;


    @ManyToOne
    private Restaurant restaurant;

    @ManyToMany
    private List<ComboMeal> comboMeals;
}