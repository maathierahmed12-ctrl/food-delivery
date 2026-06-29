package com.example.Food.Delivery.Platform.Enitity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String cuisineType;

    private String openingTime;
    private String closingTime;

    private double minOrderAmount;
    private double deliveryFee;
    private boolean acceptingOrders;
    private String restaurant;
    @ManyToOne
    private RestaurantOwner owner;

    @OneToMany
    private List<MenuItem> menuItems;

    @OneToMany
    private List<ComboMeal> comboMeals;

}