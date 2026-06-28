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

public class CorporateOrderItem {

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

    public static CorporateOrderItem toRequest(CorporateOrderItem dto) {

        CorporateOrderItem corporateOrderItem = new CorporateOrderItem();

        corporateOrderItem.setMenuItemId(dto.getMenuItemId());
        corporateOrderItem.setUnitPrice(dto.getUnitPrice());
        corporateOrderItem.setQuantity(dto.getQuantity());
        corporateOrderItem.setSpecialInstructions(dto.getSpecialInstructions());
        corporateOrderItem.setUnitPrice(dto.getUnitPrice());
        corporateOrderItem.setSpecialInstructions(dto.getSpecialInstructions());

        return corporateOrderItem;
    }
}
