package com.example.Food.Delivery.Platform.Repositories;
import com.example.Food.Delivery.Platform.Enitity.ComboMeal;
import com.example.Food.Delivery.Platform.Enitity.MenuItem;
import com.example.Food.Delivery.Platform.Enitity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query("""
        SELECT c
        FROM ComboMeal c
        WHERE c.restaurant.id = :restaurantId
        AND c.isActive = true
    """)
    List<ComboMeal> findComboMealsByRestaurantId(@Param("restaurantId") Integer restaurantId);

    @Query("""
        SELECT c
        FROM ComboMeal c
        WHERE c.restaurant.id = :restaurantId
        AND c.isAvailable = true
        AND c.isActive = true
    """)
    List<ComboMeal> findAvailableComboMeals(@Param("restaurantId") Integer restaurantId);

    @Query("""
        SELECT c
        FROM ComboMeal c
        WHERE c.isVegetarian = true
        AND c.isActive = true
    """)
    List<ComboMeal> findVegetarianMeals();

    @Query("""
        SELECT c
        FROM ComboMeal c
        WHERE c.price BETWEEN :min AND :max
        AND c.isActive = true
    """)
    List<ComboMeal> findByPriceBetween(
            @Param("min") double min,
            @Param("max") double max,
            double radiusKm);

    List<ComboMeal> findByCuisineTypeAndIsActiveTrue(String cuisineType);

    @Query("""
    SELECT m
    FROM MenuItem m
    WHERE (:keyword IS NULL OR LOWER(m.name) LIKE LOWER(CONCAT('%', :keyword, '%')))
    AND (:minCalories IS NULL OR m.calories >= :minCalories)
    AND (:maxCalories IS NULL OR m.calories <= :maxCalories)
""")
    List<MenuItem> searchMenuItems(
            @Param("keyword") String keyword,
            @Param("minCalories") Integer minCalories,
            @Param("maxCalories") Integer maxCalories
    );


    @Query("""
    SELECT r
    FROM Restaurant r
    WHERE (6371 * acos(
        cos(radians(:lat)) *
        cos(radians(r.latitude)) *
        cos(radians(r.longitude) - radians(:lng)) +
        sin(radians(:lat)) *
        sin(radians(r.latitude))
    )) <= :radiusKm
""")
    List<Restaurant> findNearbyRestaurants(
            @Param("lat") double lat,
            @Param("lng") double lng,
            @Param("radiusKm") double radiusKm
    );

    List<Restaurant> findByCuisineType(String cuisineType);
    List<Restaurant>findAvailableByRestaurant(Double maxFee);

}
