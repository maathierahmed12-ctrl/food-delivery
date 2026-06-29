package com.example.Food.Delivery.Platform.DTOs.Request;

import jakarta.validation.constraints.Max;
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
public class ReviewRequestDTO {

    @NotNull
    private String targetType;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;

    @NotBlank
    private String comment;

    public static ReviewRequestDTO toRequest(ReviewRequestDTO reviewRequestDTO) {

        ReviewRequestDTO reviewRequestDTO1 = new ReviewRequestDTO();

        reviewRequestDTO1.setTargetType(reviewRequestDTO.getTargetType());
        reviewRequestDTO1.setRating(reviewRequestDTO.getRating());
        reviewRequestDTO1.setComment(reviewRequestDTO.getComment());


        return reviewRequestDTO;
    }
}

