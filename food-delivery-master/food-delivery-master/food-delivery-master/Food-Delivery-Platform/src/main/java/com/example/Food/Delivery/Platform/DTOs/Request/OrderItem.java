package com.example.Food.Delivery.Platform.DTOs.Request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderItem {

    @NotNull
    private Long menuItemId;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private Double unitPrice;

    @NotBlank
    private String specialInstructions;


    public  static OrderItem toRequest(OrderItem orderItem){

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setMenuItemId(orderItem.getMenuItemId());
        orderItem1.setQuantity(orderItem.getQuantity());
        orderItem1.setUnitPrice(orderItem.getUnitPrice());
        orderItem1.setSpecialInstructions(orderItem.getSpecialInstructions());
        return orderItem1;
    }


}
