package com.example.Food.Delivery.Platform.Controller;

import ch.qos.logback.core.status.Status;
import com.example.Food.Delivery.Platform.Enitity.Payment;
import com.example.Food.Delivery.Platform.Repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired

    private PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public ResponseEntity<Page<Payment>> getPayments(

            @RequestParam(required = false) Method method,
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) LocalDate from,
            @RequestParam(required = false) LocalDate to,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Payment> result = paymentRepository.filterPayments(
                method, status, from, to, pageable
        );

        return ResponseEntity.ok(result);
    }

    @GetMapping("/analytics/by-method")
    public ResponseEntity<List<Object[]>> getTotalByMethod() {
        return ResponseEntity.ok(paymentRepository.totalByPaymentMethod());
    }
}