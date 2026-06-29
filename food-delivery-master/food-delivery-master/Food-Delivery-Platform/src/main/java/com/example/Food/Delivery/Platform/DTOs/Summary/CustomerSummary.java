package com.example.Food.Delivery.Platform.DTOs.Summary;

import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerSummary {


    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String customerCode;

    private Integer loyaltyPoints;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    public static class ReviewResponseDTO {

        private Long id;

        private String targetType;

        private Integer rating;

        private String comment;

        private LocalDateTime createdAt;
    }
}

