package com.example.Food.Delivery.Platform.Controller;

import com.example.Food.Delivery.Platform.Enitity.DeliveryDriver;
import com.example.Food.Delivery.Platform.Repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")

public class DeliveryController {

    @Autowired

    private DeliveryRepository deliveryRepository;

    public DeliveryController(DeliveryRepository deliveryRepository) {

        this.deliveryRepository = deliveryRepository;
    }


    @GetMapping("/drivers/nearby")
    public ResponseEntity<List<DeliveryDriver>> getNearbyDrivers(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam double radiusKm
    ) {

        List<DeliveryDriver> drivers =
                deliveryRepository.findNearbyDrivers(lat, lng, radiusKm);

        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/drivers/{driverId}/performance")

    public ResponseEntity<?> getDriverPerformance(@PathVariable Long driverId) {

        Object performance = deliveryRepository.getDriverPerformance(driverId);

        return ResponseEntity.ok(performance);
    }
}



