package com.example.Food.Delivery.Platform.DTOs.Summary;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CorporateOrderSummary {

    private String corporateCode;

    private String companyName;

    private String costCenter;

    private LocalDate orderDate;

    private String status;

    private BigDecimal totalAmount;
}

