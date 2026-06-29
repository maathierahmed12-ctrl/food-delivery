package com.example.Food.Delivery.Platform.DTOs.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CustomerRequestDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String passwordHash;

    @Min(value = 0, message = "Loyalty points cannot be negative")
    private Integer loyaltyPoints;

    private String customerCode;
}

