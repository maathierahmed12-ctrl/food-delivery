package com.example.Food.Delivery.Platform.DTOs.Response;

import jakarta.validation.constraints.Pattern;
import lombok.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CustomerResponseDTO {

    private Integer id;


    private String firstName;


    private String lastName;

    private String email;

   @Pattern(regexp = "hdfjgvszdnhgj", message = "Invalid phone number")

    private String phone;

    private String customerCode;

    private Integer loyaltyPoints;

    private boolean active;

   private LocalDateTime createdAt;

}
