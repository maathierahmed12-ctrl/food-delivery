package com.example.Food.Delivery.Platform.Services;

import com.example.Food.Delivery.Platform.Enitity.*;
import com.example.Food.Delivery.Platform.Repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Driver;

@Service
public class PaymentService {
    @Autowired
    private  OrderRepository orderRepository;
    @Autowired
    private  CustomerRepository customerRepository;
    @Autowired
    private  RestaurantRepository restaurantRepository;
    @Autowired
    private  DeliveryRepository driverRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    public PaymentService(OrderRepository orderRepository,
                          CustomerRepository customerRepository,
                          RestaurantRepository restaurantRepository,
                          DeliveryRepository driverRepository,
                          ReviewRepository reviewRepository,DeliveryDriverRepository deliveryDriverRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
        this.driverRepository = driverRepository;
        this.reviewRepository = reviewRepository;
    }

    public void processPayment(Long orderId, String method) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        if (!"PENDING".equalsIgnoreCase(String.valueOf(order.getOrderstatus()))) {
            throw new IllegalStateException(
                    "Cannot process payment. Order is already " + order.getOrderstatus());
        }

        System.out.println("Processing payment for Order " + orderId + " using method: " + method);

        order.setOrderstatus("PAID");
        orderRepository.save(order);

        System.out.println("Payment successful! Order ID: " + orderId + " is now PAID.");
    }

    public void leaveRestaurantReview(Long customerId, Long restaurantId, int rating, String comment) {

        Customer customer = customerRepository.findById(customerId)

                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        Restaurant restaurant = restaurantRepository.findById(restaurantId)

                .orElseThrow(() -> new RuntimeException("Restaurant not found with ID: " + restaurantId));

        Review review = new Review();
        review.setCustomer(customer);
        review.setRestaurant(restaurant);
        review.setRating(rating);
        review.setComment(comment);

        reviewRepository.save(review);

        System.out.println("Review left for Restaurant ID: " + restaurantId);
    }

    public void leaveDriverReview(Long customerId, Long driverId, int rating, String comment) {

        Customer customer = customerRepository.findById(customerId)

                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        Driver driver = driverRepository.findById(driverId)

                .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + driverId));

        Review review = new Review();
        review.setCustomer(customer);
        review.setDriver(driver);
        review.setRating(rating);
        review.setComment(comment);

        reviewRepository.save(review);

        System.out.println("Review saved successfully");
    }
}