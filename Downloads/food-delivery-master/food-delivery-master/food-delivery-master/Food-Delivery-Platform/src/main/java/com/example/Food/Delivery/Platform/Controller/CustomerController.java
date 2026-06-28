package com.example.Food.Delivery.Platform.Controller;


import ch.qos.logback.core.status.Status;
import com.example.Food.Delivery.Platform.DTOs.Request.CustomerRequestDTO;
import com.example.Food.Delivery.Platform.Enitity.Customer;
import com.example.Food.Delivery.Platform.Enitity.Order;
import com.example.Food.Delivery.Platform.Repositories.CustomerRepository;
import com.example.Food.Delivery.Platform.Repositories.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/customers")

public class CustomerController {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public CustomerController(CustomerRepository customerRepository,
                              OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Customer>> searchCustomers(
            @RequestParam String name,
            @RequestParam int page,
            @RequestParam int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        return ResponseEntity.ok(
                customerRepository.searchByName(name, pageable)
        );
    }

    @GetMapping("/{id}/orders")

    public ResponseEntity<Page<Order>> getCustomerOrders(
            @PathVariable Long id,
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) LocalDate from,
            @RequestParam(required = false) LocalDate to,
            @RequestParam int page,
            @RequestParam int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        return ResponseEntity.ok(
                orderRepository.filterCustomerOrders(id, status, from, to, pageable)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerRequestDTO dto
    ) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (dto.getPhone() != null) {

            customer.setPhone(dto.getPhone());
        }

        if (dto.getPhone() != null) customer.setPhone(dto.getPhone());

        return ResponseEntity.ok(customerRepository.save(customer));
    }
}

