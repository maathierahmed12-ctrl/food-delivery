package com.example.Food.Delivery.Platform.DTOs.Request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Payment {

    @NotNull
    private String paymentMethod;

    @NotNull
    private String status;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private Double amount;

    @NotBlank
    private String transactionRef;

    public static Payment toRequest(Payment payment) {

        Payment payment1 = new Payment();

        payment1.setPaymentMethod(payment.getPaymentMethod());
        payment1.setStatus(payment.getStatus());
        payment1.setAmount(payment.getAmount());
        payment1.setTransactionRef(payment.getTransactionRef());

        return payment1;

    }
}

