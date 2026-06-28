package com.example.Food.Delivery.Platform.Repositories;

import com.example.Food.Delivery.Platform.Enitity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {

    List<Review> findByProductId(Long productId, Pageable pageable);

    List<Review> findByUserId(Long userId);

    List<Review> findByRating(int rating);

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.product.id = :productId")
    Double getAverageRatingByProductId(@Param("productId") Long productId);

    boolean existsByUserIdAndProductId(Long userId, Long productId);
    
    @Query("""
        SELECT AVG(r.rating)
        FROM Review r
        WHERE r.restaurant.id = :restaurantId
    """)
    Double getRestaurantAverageRating(@Param("restaurantId") Long restaurantId);

    @Query("""
        SELECT AVG(r.rating)
        FROM Review r
        WHERE r.driver.id = :driverId
    """)
    Double getDriverAverageRating(@Param("driverId") Long driverId);

    @Query("""
        SELECT r
        FROM Review r
        WHERE r.restaurant.id = :restaurantId
        ORDER BY r.id DESC
    """)
    Page<Review> getRestaurantReviews(
            @Param("restaurantId") Long restaurantId,
            Pageable pageable
    );

}




