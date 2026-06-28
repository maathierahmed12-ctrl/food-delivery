package com.example.Food.Delivery.Platform.DTOs.Request;

import com.example.Food.Delivery.Platform.Enitity.CorporateOrder;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Setter
@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CorporateOrderRequestDTO {

    @NotNull
    private Double totalAmount;

        @NotNull
        private LocalDateTime orderDate;

        @NotBlank
        private String status;

        @NotNull
        private BigDecimal subtotal;

        @NotNull
        private BigDecimal deliveryFee;

        @NotNull
        private BigDecimal discountAmount;

        @NotNull

        private String deliveryNotes;

    @NotEmpty(message = "Order must have at least one item")
    private List<OrderItemRequestDTO> orderItems;

    public static CorporateOrderRequestDTO toRequestDTO(CorporateOrder corporateOrder) {

        CorporateOrderRequestDTO corporateOrderRequestDTO = new CorporateOrderRequestDTO();

        corporateOrderRequestDTO.setTotalAmount(corporateOrder.getTotalAmount());
        corporateOrderRequestDTO.setStatus(corporateOrder.getStatus());
        corporateOrderRequestDTO.setStatus(corporateOrder.getStatus());
        corporateOrderRequestDTO.setOrderDate(LocalDateTime.now());
        corporateOrderRequestDTO.setDiscountAmount(BigDecimal.ZERO);
        corporateOrderRequestDTO.setDeliveryNotes("");
        corporateOrderRequestDTO.setDeliveryFee(BigDecimal.ZERO);

        return corporateOrderRequestDTO;

    }
    }


