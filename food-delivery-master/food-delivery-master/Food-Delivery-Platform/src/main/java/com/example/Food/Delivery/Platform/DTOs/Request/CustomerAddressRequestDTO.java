package com.example.Food.Delivery.Platform.DTOs.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CustomerAddressRequestDTO {

    @NotBlank
    private String street;

    @NotBlank
    private String city;
    @NotBlank
    private String building;

    private Boolean isDefault;
}

