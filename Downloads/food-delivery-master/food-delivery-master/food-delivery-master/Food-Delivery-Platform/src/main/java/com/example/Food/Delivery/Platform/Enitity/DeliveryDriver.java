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
    private Boolean isAvailable;
    private double latitude;
    private double longitude;


    @OneToMany
    private List<Delivery> deliveries;
}