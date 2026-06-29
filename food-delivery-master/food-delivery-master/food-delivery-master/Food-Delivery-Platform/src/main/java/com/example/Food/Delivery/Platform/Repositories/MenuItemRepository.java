package com.example.Food.Delivery.Platform.Repositories;
import com.example.Food.Delivery.Platform.Enitity.MenuItem;
import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Integer> {

    @Query("""

            SELECT m FROM MenuItem m
    WHERE m.restaurant.id = :restaurantId
    """)
    List<MenuItem> findByRestaurantId(@Param("restaurantId") Integer restaurantId);

    @Query("""
    SELECT m FROM MenuItem m
    WHERE m.restaurant.id = :restaurantId
    AND m.isAvailable = true
    """)
    List<MenuItem> findByRestaurantIdAndAvailableTrue(@Param("restaurantId") Integer restaurantId);

    @Query("""
    SELECT m FROM MenuItem m
    WHERE m.isVegetarian = true
    """)
    List<MenuItem> findByVegetarianTrue();

    @Query("""
    SELECT m FROM MenuItem m
    WHERE m.price BETWEEN :min AND :max
    """)
    List<MenuItem> findByPriceBetween(@Param("min") double min,
                                      @Param("max") double max);

    @Query("SELECT m FROM MenuItem m JOIN m.comboMeals c WHERE c.id = :comboMealId")
    List<MenuItem> findByComboMealId(@Param("comboMealId") Long comboMealId);

    @Query("""
    SELECT m FROM MenuItem m
    WHERE m.createdDate BETWEEN :start AND :end
    """)
    List<MenuItem> findByCreatedDateBetween(@Param("start") LocalDateTime start,
                                            @Param("end") LocalDateTime end);

    @Query("""
    SELECT m FROM MenuItem m
    WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
    """)

    List<MenuItem> findByNameContainingIgnoreCase(@Param("keyword") String keyword);
    }