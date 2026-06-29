package com.example.Food.Delivery.Platform.Controller;


import com.example.Food.Delivery.Platform.Enitity.Review;
import com.example.Food.Delivery.Platform.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")

public class ReviewController {


    @Autowired

    private  ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/restaurant/{restaurantId}/average")
    public ResponseEntity<Double> getRestaurantAverage(@PathVariable Integer restaurantId) {
        return ResponseEntity.ok(
                reviewRepository.getRestaurantAverageRating(restaurantId)
        );
    }

    @GetMapping("/driver/{driverId}/average")
    public ResponseEntity<Double> getDriverAverage(@PathVariable Integer driverId) {
        return ResponseEntity.ok(reviewRepository.getDriverAverageRating(driverId)
        );
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<Page<Review>> getRestaurantReviews(
            @PathVariable Integer restaurantId,
            @RequestParam int page,
            @RequestParam int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        return ResponseEntity.ok(reviewRepository.getRestaurantReviews(restaurantId, pageable)
        );
    }
}