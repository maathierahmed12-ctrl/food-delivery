package com.example.Food.Delivery.Platform.DTOs.Response;

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
}
