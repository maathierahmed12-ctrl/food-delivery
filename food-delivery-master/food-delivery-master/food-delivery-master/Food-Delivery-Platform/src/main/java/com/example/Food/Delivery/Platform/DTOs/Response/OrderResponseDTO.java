package com.example.Food.Delivery.Platform.DTOs.Response;

import com.example.Food.Delivery.Platform.Enitity.Delivery;
import com.example.Food.Delivery.Platform.Enitity.Order;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderResponseDTO {

    private Long id;

    private String orderCode;

    private LocalDateTime orderDate;

    private String status;

    private BigDecimal subtotal;

    private BigDecimal deliveryFee;

    private BigDecimal discountAmount;

    private BigDecimal totalAmount;

    private String deliveryNotes;

    public static OrderResponseDTO toResponse(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();

        dto.setOrderCode(order.getOrderCode());
        dto.setOrderDate(order.getOrderDate());
        dto.setOrderDate(order.getOrderDate());
        dto.setDeliveryNotes(order.getDeliveryNotes());

        return dto;


    }
}