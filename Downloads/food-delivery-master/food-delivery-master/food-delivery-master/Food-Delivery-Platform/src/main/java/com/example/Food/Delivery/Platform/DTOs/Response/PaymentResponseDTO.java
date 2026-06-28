package com.example.Food.Delivery.Platform.DTOs.Response;

import com.example.Food.Delivery.Platform.Enitity.Order;
import com.example.Food.Delivery.Platform.Enitity.Payment;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PaymentResponseDTO {

    private Long id;

    private String paymentMethod;

    private String status;

    private Double amount;

    private String transactionRef;

    private LocalDateTime processedAt;

    public static PaymentResponseDTO toResponse(Payment payment) {
        PaymentResponseDTO dto = new PaymentResponseDTO();

        dto.setId(payment.getId());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setStatus(payment.getStatus());
        dto.setAmount(payment.getAmount());
        dto.setTransactionRef(payment.getTransactionRef());
        dto.setProcessedAt(payment.getProcessedAt());

        return dto;

    }
}