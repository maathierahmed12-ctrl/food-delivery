package com.example.Food.Delivery.Platform.Repositories;
import com.example.Food.Delivery.Platform.Enitity.ComboMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComboMealRepository extends JpaRepository<ComboMeal, Integer> {

    @Query("SELECT C  FROM ComboMeal C " + "WHERE C.restaurant = : value AND C.isAvailable = true")
    List<ComboMeal> RestaurantId(@Param("Id") String Id);

    @Query("SELECT C FROM ComboMeal C  " + " WHERE C.restaurant = : value AND C.isAvailable = true")
    List<ComboMeal> RestaurantIdAndIsAvailableTrue(@Param("id") String id);

    @Query("SELECT C  FROM ComboMeal C " + "WHERE C.isAvailable = : value AND C.isAvailable = true")
    List<ComboMeal> IsVegetarianTrue();


    @Query("SELECT C  FROM ComboMeal C " + "WHERE C.totalPrice = : value AND C.isAvailable = true")
    List<ComboMeal> PriceBetween(@Param("min") double min, @Param("max") double max);

    @Query("SELECT C  FROM ComboMeal C " + "WHERE C.comboName = : value AND C.isAvailable = true")
    List<ComboMeal> ComboMeals_Id(@Param(" menuItemId") Integer menuItemId);
    List<ComboMeal> findByRestaurant_Id(Long restaurantId);
}




