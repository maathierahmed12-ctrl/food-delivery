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
public class DeliveryDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String phone;
    private String passwordHash;

    private String driverCode;

    private String vehicleType;
    private String vehiclePlate;

    private Double currentLat;
    private Double currentLng;

    private boolean isOnline;

    @OneToMany
    private List<Delivery> deliveries;
}