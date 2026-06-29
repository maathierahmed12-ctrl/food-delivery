package com.example.Food.Delivery.Platform.Enitity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deliveries")
public class Delivery {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String trackingCode;

        private String status;

        private LocalDateTime assignedAt;
        private LocalDateTime pickedUpAt;
        private LocalDateTime deliveredAt;

        private boolean isActive;

        @OneToOne
        @JoinColumn(name = "order_id")
        private Order order;

        @ManyToOne
        @JoinColumn(name = "driver_id")
        private DeliveryDriver driver;
}
