package com.example.Food.Delivery.Platform.Services;

import com.example.Food.Delivery.Platform.Enitity.Customer;
import com.example.Food.Delivery.Platform.Enitity.Order;
import com.example.Food.Delivery.Platform.Enitity.Restaurant;
import com.example.Food.Delivery.Platform.Enitity.Review;
import com.example.Food.Delivery.Platform.Repositories.CustomerRepository;
import com.example.Food.Delivery.Platform.Repositories.DeliveryRepositories;
import com.example.Food.Delivery.Platform.Repositories.OrderRepositories;
import com.example.Food.Delivery.Platform.Repositories.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Driver;

@Service
public class PaymentService {

        private final OrderRepositories orderRepository;
        private final CustomerRepository customerRepository;
        private final RestaurantRepository restaurantRepository;
        private final DeliveryRepositories driverRepository;
        private final RestaurantRepository reviewRepository;

        public PaymentService(OrderRepositories orderRepository, CustomerRepository customerRepository,
                              RestaurantRepository restaurantRepository, DeliveryRepositories driverRepository,
                              RestaurantRepository reviewRepository) {
            this.orderRepository = orderRepository;
            this.customerRepository = customerRepository;
            this.restaurantRepository = restaurantRepository;
            this.driverRepository = driverRepository;
            this.reviewRepository = reviewRepository;
        }

        @Transactional
        public void processPayment(Integer orderId, String method) {
            Order order = orderRepository.findById(orderId)
                    .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

            order.setStatus("PAID");
            orderRepository.save(order);

            System.out.println("Payment processed for Order ID: " + orderId + " using method: " + method);
        }

        @Transactional
        public void refundPayment(Integer orderId) {
            Order order = orderRepository.findById(orderId)
                    .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

            if (!"PAID".equalsIgnoreCase(order.getStatus())) {
                throw new IllegalStateException("Cannot refund an order that has not been paid yet.");
            }

            order.setStatus("REFUNDED");
            orderRepository.save(order);

            System.out.println("Payment refunded for Order ID: " + orderId);
        }


        @Transactional
        public void leaveRestaurantReview(Long customerId, Integer restaurantId, int rating, String comment) {
            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

            Restaurant restaurant = restaurantRepository.findById(restaurantId)
                    .orElseThrow(() -> new RuntimeException("Restaurant not found with ID: " + restaurantId));

            Review review = new Review();
            review.setCustomer(customer);
            review.setRestaurant(restaurant);
            review.setRating(rating);
            review.setComment(comment);


            System.out.println("Review left for Restaurant ID: " + restaurantId + " by Customer ID: " + customerId);
        }


        @Transactional

        public void leaveDriverReview(Integer customerId, Long driverId, int rating, String comment) {
            Customer customer = customerRepository.findById(Long.valueOf(customerId))
                    .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

            Driver driver = driverRepository.findById(driverId)
                    .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + driverId));

            Review review = new Review();
            review.setCustomer(customer);
            review.setRating(rating);
            review.setComment(comment);


            System.out.println("Review left for Driver ID: " + driverId + " by Customer ID: " + customerId);
        }
    }

