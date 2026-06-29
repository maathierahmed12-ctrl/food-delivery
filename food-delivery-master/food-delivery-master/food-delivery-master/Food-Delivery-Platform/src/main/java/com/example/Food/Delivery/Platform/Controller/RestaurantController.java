package com.example.Food.Delivery.Platform.Controller;

import com.example.Food.Delivery.Platform.Enitity.Restaurant;
import com.example.Food.Delivery.Platform.Repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")

public class RestaurantController {

    @Autowired
    private  RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/near")
    public ResponseEntity<List<Restaurant>> getNearbyRestaurants(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam double radiusKm
    ) {
        return ResponseEntity.ok(restaurantRepository.findNearbyRestaurants(lat, lng, radiusKm )
        );
    }

    @GetMapping("/{id}/analytics")
    public ResponseEntity<?> getAnalytics(@PathVariable Integer id) {
        return ResponseEntity.ok(
                restaurantRepository.getReferenceById(id)
        );
    }

    @GetMapping("/menu/search")
    public ResponseEntity<?> searchMenuItems(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Integer minCalories,
            @RequestParam(required = false) Integer maxCalories
    ) {

        return ResponseEntity.ok(restaurantRepository.searchMenuItems(keyword, minCalories, maxCalories)
        );
    }
}
