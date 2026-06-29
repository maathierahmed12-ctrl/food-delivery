package com.example.Food.Delivery.Platform.Controller;

import com.example.Food.Delivery.Platform.Enitity.Delivery;
import com.example.Food.Delivery.Platform.Repositories.DeliveryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    private final DeliveryRepository deliveryRepository;

    public DeliveryController(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
        Delivery savedDelivery = deliveryRepository.save(delivery);
        return ResponseEntity.ok(savedDelivery);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable Integer id) {
        return deliveryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }


    @GetMapping("/nearby")
    public List<Delivery> getNearbyDeliveries(@RequestParam double lat,
                                              @RequestParam double lng,
                                              @RequestParam double radius) {
        return deliveryRepository.findNearbyDeliveries(lat);
    }
    @GetMapping("/driver/{driverId}")
    public List<Delivery> getDeliveriesByDriver(@PathVariable Integer driverId) {
        return deliveryRepository.findByDriver_Id(driverId);
    }
}



