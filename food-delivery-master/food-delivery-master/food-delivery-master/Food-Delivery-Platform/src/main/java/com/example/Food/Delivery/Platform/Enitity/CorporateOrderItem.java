package com.example.Food.Delivery.Platform.Enitity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Data

public class CorporateOrderItem {

    @Id
    private Integer id;

    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private String specialInstructions;

    @ManyToOne
    private CorporateOrder corporateOrder;

    @ManyToOne
    private MenuItem menuItem;
}

