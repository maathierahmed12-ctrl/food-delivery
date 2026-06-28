package com.example.Food.Delivery.Platform.Enitity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Driver;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deliveries")
@Data

public class Delivery {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String trackingCode;
        private String status;

        private LocalDateTime assignedAt;
        private LocalDateTime pickedUpAt;
        private LocalDateTime deliveredAt;
        private boolean availableDriver;

        @OneToOne
        @JoinColumn(name = "order_id")
        private Order order;

        @ManyToOne
        @JoinColumn(name = "driver_id")
        private Delivery driver;


}
