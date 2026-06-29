package com.example.Food.Delivery.Platform.Services;


import com.example.Food.Delivery.Platform.DTOs.Request.RestaurantRequestDTO;
import com.example.Food.Delivery.Platform.Enitity.ComboMeal;
import com.example.Food.Delivery.Platform.Enitity.MenuItem;
import com.example.Food.Delivery.Platform.Enitity.Restaurant;
import com.example.Food.Delivery.Platform.Repositories.ComboMealRepository;
import com.example.Food.Delivery.Platform.Repositories.MenuItemRepository;
import com.example.Food.Delivery.Platform.Repositories.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private  RestaurantRepository restaurantRepository;
    @Autowired
    private MenuItemRepository menuItemRepositories;
    @Autowired
    private ComboMealRepository comboMealRepository;

    public RestaurantService(RestaurantRepository restaurantRepository,
                             MenuItemRepository menuItemRepositories,
                             ComboMealRepository comboMealRepository) {

        this.restaurantRepository = restaurantRepository;
        this.menuItemRepositories = menuItemRepositories;
        this.comboMealRepository = comboMealRepository;
    }



    public Restaurant createRestaurant(RestaurantRequestDTO dto, Integer ownerId) {

        Restaurant restaurant = new Restaurant();

        restaurant.setName(dto.getName());
        restaurant.setDescription(dto.getDescription());
        restaurant.setCuisineType(dto.getCuisineType());
        restaurant.setOpeningTime(dto.getName());
        restaurant.setClosingTime(dto.getCuisineType());
        restaurant.setDeliveryFee(dto.getDeliveryFee());
        restaurant.setMinOrderAmount(dto.getMinOrderAmount());
        restaurant.setAcceptingOrders(true);

        return restaurantRepository.save(restaurant);
    }

    public Restaurant createRestaurant(Restaurant restaurant, Integer ownerId) {

        restaurant.setAcceptingOrders(true);
        return restaurantRepository.save(restaurant);
    }

    public void toggleAcceptingOrders(Integer restaurantId, boolean status) {

        Restaurant restaurant = getRestaurant(restaurantId);
        restaurant.setAcceptingOrders(status);

        restaurantRepository.save(restaurant);
    }

    public void updateDeliveryFee(Integer restaurantId, double newFee) {

        Restaurant restaurant = getRestaurant(restaurantId);
        restaurant.setDeliveryFee(newFee);

        restaurantRepository.save(restaurant);
    }

    public void updateMinOrderAmount(Integer restaurantId, double minOrderAmount) {

        Restaurant restaurant = getRestaurant(restaurantId);
        restaurant.setMinOrderAmount(minOrderAmount);

        restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getRestaurantsByCuisine(String cuisine) {

        return restaurantRepository.findByCuisineType(cuisine);
    }

    public List<Restaurant> getRestaurantsUnderDeliveryFee(double maxFee) {

        return restaurantRepository.findAvailableByRestaurant(maxFee);
    }

    public List<MenuItem> getMenuForRestaurant(Integer restaurantId) {

        return menuItemRepositories.findByRestaurantId(restaurantId);
    }

    public List<ComboMeal> getComboMealsForRestaurant(Long restaurantId) {

        return comboMealRepository.findByRestaurant_Id(restaurantId);
    }

    public void bulkUpdateMenuItemPrices(Long restaurantId, double percentageIncrease) {

        List<MenuItem> items = menuItemRepositories.findByComboMealId(restaurantId);

        for (MenuItem item : items) {

            double updatedPrice = item.getPrice()
                    + (item.getPrice() * percentageIncrease / 100);

            item.setPrice(updatedPrice);
        }

        menuItemRepositories.saveAll(items);
    }

    private Restaurant getRestaurant(Integer restaurantId) {

        return restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }
}
