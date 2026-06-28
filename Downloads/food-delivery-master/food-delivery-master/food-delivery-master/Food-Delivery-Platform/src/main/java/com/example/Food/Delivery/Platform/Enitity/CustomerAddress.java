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

public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String building;
    private boolean isDefault;
    private String address;

    @ManyToOne
    private Customer customer;



}

