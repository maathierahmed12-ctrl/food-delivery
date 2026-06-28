package com.example.Food.Delivery.Platform.Services;

import com.example.Food.Delivery.Platform.Enitity.*;
import com.example.Food.Delivery.Platform.Repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.time.LocalDateTime;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private DriverRepository driverRepository;

    @Transactional

    public void processPayment(Long orderId, String method){

        Customer customer = customerRepository.findById(driverRepository.count())
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerRepository));

        Restaurant restaurant = restaurantRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with ID: " + restaurantRepository));

        Review review = new Review();
        review.setCustomer(customer);
        review.setDriver(null);
        review.setTargetType("RESTAURANT");
        review.setRating(review.getRating());
        review.setComment(review.getComment());
        review.setCreatedAt(LocalDateTime.now());

        reviewRepository.save(review);
    }

    @Transactional

    public void refundPayment(Long orderId){

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        if (!"COMPLETED".equals(order.getDeliveryNotes())) {
            throw new IllegalStateException("Cannot refund an order that has not been successfully paid.");
        }

        order.setPayment(null);
        orderRepository.save(order);
    }

    @Transactional
    public void leaveRestaurantReview(Long customerId, Long restaurantId, int rating,String comment) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        com.example.Food.Delivery.Platform.Enitity.Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with ID: " + restaurantId));

        Review review = new Review();
        review.setCustomer(customer);
        review.setRestaurant(restaurant);
        review.setDriver(null);
        review.setTargetType("RESTAURANT");
        review.setRating(rating);
        review.setComment(comment);
        review.setCreatedAt(LocalDateTime.now());

        reviewRepository.save(review);
    }

    @Transactional
    public void leaveDriverReview(Long customerId, Integer driverId, int rating, String comment) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + driverId));

        Review review = new Review();
        review.setCustomer(customer);
        review.setRestaurant(null);
        review.setDriver((DeliveryDriver) driver);
        review.setTargetType("DRIVER");
        review.setRating(rating);
        review.setComment(comment);
        review.setCreatedAt(LocalDateTime.now());

        reviewRepository.save(review);
    }
}




