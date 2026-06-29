package com.example.Food.Delivery.Platform.DTOs.Summary;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReviewSummaryDTO {

    private Integer rating;

    private String comment;
}
