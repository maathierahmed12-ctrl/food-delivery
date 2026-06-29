package com.example.Food.Delivery.Platform.Enitity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class ComboMeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comboName;
    private String description;
    private double totalPrice;
    private boolean isAvailable;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToMany
    private List<MenuItem> items;
}