package com.example.Food.Delivery.Platform.Repositories;
import com.example.Food.Delivery.Platform.Enitity.ComboMeal;
import com.example.Food.Delivery.Platform.Enitity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query("""
        SELECT c FROM ComboMeal c
    WHERE c.restaurant.id = :restaurantId
    AND c.isActive = true
            """)
    List<ComboMeal> findByRestaurantId(@Param("restaurantId") Integer restaurantId);


    @Query("""
    SELECT c FROM ComboMeal c
    WHERE c.restaurant.id = :restaurantId
    AND c.isAvailable = true
    AND c.isActive = true
            """)
    List<Restaurant> findAvailableByRestaurant(@Param("restaurantId") double restaurantId);

    @Query("""
    SELECT c FROM ComboMeal c
    WHERE c.isVegetarian = true
    AND c.isActive = true
            """)
    List<ComboMeal> findVegetarian();

    @Query("""
    SELECT c FROM ComboMeal c
    WHERE c.price BETWEEN :min AND :max
    AND c.isActive = true
            """)
    List<Restaurant> findByPriceBetween(@Param("min") double min,
                                       @Param("max") double max);

    @Query("""
    SELECT c FROM ComboMeal c
    WHERE c.id = :menuItemId
    AND c.isActive = true
            """)
    List<Restaurant> findByCuisineType(String cuisineType);

}

