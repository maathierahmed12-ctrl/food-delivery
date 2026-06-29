package com.example.Food.Delivery.Platform.Controller;

import com.example.Food.Delivery.Platform.Enitity.Order;
import com.example.Food.Delivery.Platform.Enitity.Payment;
import com.example.Food.Delivery.Platform.Enitity.Restaurant;
import com.example.Food.Delivery.Platform.Enitity.Review;
import com.example.Food.Delivery.Platform.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportingController {

@Autowired
    private  OrderRepository orderRepository;
@Autowired
    private PaymentRepository paymentRepository;
@Autowired
    private  CustomerRepository customerRepository;
@Autowired
    private  RestaurantRepository restaurantRepository;
@Autowired
    private  DeliveryRepository deliveryDriverRepository;
@Autowired
    private  ReviewRepository reviewRepository;

    public ReportingController(
            OrderRepository orderRepository,
            PaymentRepository paymentRepository,
            CustomerRepository customerRepository,
            RestaurantRepository restaurantRepository,
            DeliveryRepository deliveryDriverRepository,
            ReviewRepository reviewRepository
    ) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
        this.deliveryDriverRepository = deliveryDriverRepository;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/summary")
    public ResponseEntity<?> getSystemSummary() {

        long totalCustomers = customerRepository.count();
        long totalRestaurants = restaurantRepository.count();
        long totalOrders = orderRepository.count();
        long totalDrivers = deliveryDriverRepository.count();

        Double totalRevenue = paymentRepository.totalRevenue();

        return ResponseEntity.ok(new Object() {

            @Autowired
            public  long customers = totalCustomers;
            @Autowired
            public  long restaurants = totalRestaurants;
            @Autowired
            public  long orders = totalOrders;
            @Autowired
            public  long drivers = totalDrivers;
            @Autowired
            public  Double revenue = totalRevenue;
        });
    }

    @GetMapping("/orders")

    public ResponseEntity<?> ordersReport() {

        return ResponseEntity.ok(new Order() {
            @Autowired
            public  long total = orderRepository.count();
            @Autowired
            public List<Order> active = orderRepository.findAll();
        });
    }


    @GetMapping("/payments")
    public ResponseEntity<?> paymentsReport() {

        return ResponseEntity.ok(new Payment() {
            @Autowired
            public  Double revenue = paymentRepository.totalRevenue();
            @Autowired
            public  long failedPayments = paymentRepository.hashCode();
        }

        );
    }


    @GetMapping("/reviews")
    public ResponseEntity<?> reviewsReport() {

        return ResponseEntity.ok(new Review() {
            @Autowired
            public  long totalReviews = reviewRepository.count();
        });
    }

    @GetMapping("/top-restaurants")
    public ResponseEntity<?> topRestaurants() {

        return ResponseEntity.ok(new Restaurant() {
            @Autowired
            public  long totalRestaurants = restaurantRepository.count();
        });
    }
}

