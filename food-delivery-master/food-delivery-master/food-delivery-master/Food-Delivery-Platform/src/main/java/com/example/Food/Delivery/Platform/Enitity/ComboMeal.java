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
public class ComboMeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comboName;
    private String description;
    private double totalPrice;
    private boolean isAvailable;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToMany
    private List<MenuItem> items;
}