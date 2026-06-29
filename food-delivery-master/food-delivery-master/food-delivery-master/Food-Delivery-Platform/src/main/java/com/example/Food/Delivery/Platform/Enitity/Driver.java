package com.example.Food.Delivery.Platform.Enitity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Data

public class Driver {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String phone;

    private boolean online;
    private boolean available;



}