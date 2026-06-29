package com.example.Food.Delivery.Platform.DTOs.Summary;

import com.example.Food.Delivery.Platform.DTOs.Request.CorporateOrderRequestDTO;
import com.example.Food.Delivery.Platform.DTOs.Request.OrderItemRequestDTO;
import com.example.Food.Delivery.Platform.Enitity.CorporateOrder;
import com.example.Food.Delivery.Platform.Utils.HelperUtils;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class CorporateOrderItem {

    private Integer quantity;

    private Double totalPrice;

    private String specialInstructions;

}

