package com.example.Food.Delivery.Platform.DTOs.Summary;

import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerAddressSummary {

    private String street;

    private String city;

    private String building;

    private Boolean isDefault;
}

