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
}

