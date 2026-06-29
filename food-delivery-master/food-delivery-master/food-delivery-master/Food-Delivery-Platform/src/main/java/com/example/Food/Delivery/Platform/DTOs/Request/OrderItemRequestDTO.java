package com.example.Food.Delivery.Platform.DTOs.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

  public class OrderItemRequestDTO {

    @NotBlank(message = "Order code is required")
    private String orderCode;

    private String deliveryNotes;

  @NotNull(message = "Menu item ID is required")
  private Integer menuItemId;

  @Positive(message = "Quantity must be greater than zero")
  private int quantity;

  public static OrderItemRequestDTO toRequestDTO(OrderItem orderItem) {

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    orderItemRequestDTO.setOrderCode(orderItemRequestDTO.getOrderCode());
    orderItemRequestDTO.setDeliveryNotes(orderItemRequestDTO.getDeliveryNotes());
    orderItemRequestDTO.setMenuItemId(orderItemRequestDTO.getMenuItemId());
    orderItemRequestDTO.setQuantity(orderItemRequestDTO.getQuantity());
    return orderItemRequestDTO;
  }
}


