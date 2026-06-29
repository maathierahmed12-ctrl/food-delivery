package com.example.Food.Delivery.Platform.DTOs.Response;

import com.example.Food.Delivery.Platform.DTOs.Request.RestaurantOwner;
import com.example.Food.Delivery.Platform.Enitity.Review;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReviewResponseDTO {

    private Long id;

    private String targetType;

    private Integer rating;

    private String comment;

    private LocalDateTime createdAt;

    public static ReviewResponseDTO toResponse(Review review) {

        ReviewResponseDTO dto = new ReviewResponseDTO();

        dto.setTargetType(review.getTargetType());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setCreatedAt(review.getCreatedAt());
        return dto;
    }
}