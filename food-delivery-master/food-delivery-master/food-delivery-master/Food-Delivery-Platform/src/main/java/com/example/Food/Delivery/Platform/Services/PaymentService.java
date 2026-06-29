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
    private  ReviewRepository reviewRepository;
     @Autowired
    private  DeliveryDriverRepository deliveryDriverRepository;

    @Autowired
    public PaymentService(OrderRepository orderRepository,
                          CustomerRepository customerRepository,
                          RestaurantRepository restaurantRepository,
                          DeliveryRepository driverRepository,
                          ReviewRepository reviewRepository,
                          DeliveryDriverRepository deliveryDriverRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
        this.driverRepository = driverRepository;
        this.reviewRepository = reviewRepository;
        this.deliveryDriverRepository = deliveryDriverRepository;
    }

    public void processPayment(Integer orderId, String method) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        if (!"PENDING".equalsIgnoreCase(String.valueOf(order.getStatus()))) {
            throw new IllegalStateException(
                    "Cannot process payment. Order is already " + order.getStatus());
        }

        System.out.println("Processing payment for Order " + orderId + " using method: " + method);

        order.setStatus("PAID");
        orderRepository.save(order);

        System.out.println("Payment successful! Order ID: " + orderId + " is now PAID.");
    }

    public void leaveRestaurantReview(Integer customerId, Integer restaurantId, int rating, String comment) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

    }
}