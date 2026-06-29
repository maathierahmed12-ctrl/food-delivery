package com.example.Food.Delivery.Platform.DTOs.Response;

import com.example.Food.Delivery.Platform.DTOs.Summary.ComboMeal;
import com.example.Food.Delivery.Platform.DTOs.Summary.CorporateOrderItem;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorporateOrderItemResponseDTO {

    private Long id;

    private Integer quantity;

    private Double unitPrice;

    private Double totalPrice;

    private String specialInstructions;


    public static CorporateOrderItem toResponse(CorporateOrderItem corporateOrderItem) {

        CorporateOrderItem dto = new CorporateOrderItem();

       dto.setQuantity(corporateOrderItem.getQuantity());
       dto.setTotalPrice(corporateOrderItem.getTotalPrice());
       dto.setSpecialInstructions(corporateOrderItem.getSpecialInstructions());

        return dto;

    }

}
