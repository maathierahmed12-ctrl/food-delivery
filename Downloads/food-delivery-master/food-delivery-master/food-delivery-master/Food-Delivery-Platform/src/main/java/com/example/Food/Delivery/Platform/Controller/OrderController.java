package com.example.Food.Delivery.Platform.Controller;


import ch.qos.logback.core.status.Status;
import com.example.Food.Delivery.Platform.Enitity.Order;
import com.example.Food.Delivery.Platform.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/api/orders")

public class OrderController {

    @Autowired

    private  OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}/timeline")
    public ResponseEntity<?> getOrderTimeline(@PathVariable Long id) {
        return ResponseEntity.ok(orderRepository.getOrderTimeline(id));
    }

    @PostMapping("/{id}/reorder")
    public ResponseEntity<Order> reorder(@PathVariable Long id) {

        Order oldOrder = orderRepository.findById((id))
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Order newOrder = new Order();

        newOrder.setCustomer(oldOrder.getCustomer());
        newOrder.setRestaurant(oldOrder.getRestaurant());
        newOrder.setId(oldOrder.getId());

        return ResponseEntity.ok(orderRepository.save(newOrder));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Page<Order>> getCustomerOrders(
            @PathVariable Long customerId,
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) LocalDate from,
            @RequestParam(required = false) LocalDate to,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Order> orders = orderRepository.filterCustomerOrders(
                customerId,
                status,
                from,
                to,
                pageable
        );

        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}/eta")
    public ResponseEntity<?> getETA(@PathVariable Long id) {

        return ResponseEntity.ok(orderRepository.calculateETA(id));
    }
}

