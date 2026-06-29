package com.example.Food.Delivery.Platform.Enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int Quantity;
    private double unitPrice;
    private double totalPrice;
    private String specialInstructions;


    @ManyToOne
    private CorporateOrder corporateOrder;

    @ManyToOne
    private MenuItem menuItem;


}