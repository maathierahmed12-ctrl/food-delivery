package com.example.Food.Delivery.Platform.DTOs.Response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorporateOrderResponse {

    private Long id;

    private String corporateCode;

    private String companyName;

    private String costCenter;

    private LocalDate orderDate;

    private String status;

    private BigDecimal totalAmount;

    @Data
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewSummaryDTO {


        private Integer rating;

        private String comment;
    }
}

