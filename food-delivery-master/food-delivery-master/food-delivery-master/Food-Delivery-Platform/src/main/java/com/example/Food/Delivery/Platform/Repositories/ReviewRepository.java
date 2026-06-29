package com.example.Food.Delivery.Platform.Repositories;

import com.example.Food.Delivery.Platform.Enitity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {

    List<Review> findByProductId(Integer productId, Pageable pageable);

    List<Review> findByUserId(Integer userId);

    List<Review> findByRating(int rating);

    boolean existsByUserIdAndProductId(Integer userId, Integer productId);
    
    @Query("""
        SELECT AVG(r.rating)
        FROM Review r
        WHERE r.restaurant.id = :restaurantId
    """)
    Double getRestaurantAverageRating(@Param("restaurantId") Integer restaurantId);

    @Query("""
        SELECT AVG(r.rating)
        FROM Review r
        WHERE r.driver.id = :driverId
    """)
    Double getDriverAverageRating(@Param("driverId") Integer driverId);

    @Query("""
        SELECT r
        FROM Review r
        WHERE r.restaurant.id = :restaurantId
        ORDER BY r.id DESC
    """)
    Page<Review> getRestaurantReviews(
            @Param("restaurantId") Integer restaurantId,
            Pageable pageable
    );

}




