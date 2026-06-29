package com.example.Food.Delivery.Platform.Enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class CorporateOrder {
        private String corporateCode;
        private String companyName;
        private String costCenter;

        private LocalDate orderDate;
        private String status;

        private double totalAmount;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private Restaurant restaurant;

        @OneToMany
        private List<CorporateOrder> items;
    }



