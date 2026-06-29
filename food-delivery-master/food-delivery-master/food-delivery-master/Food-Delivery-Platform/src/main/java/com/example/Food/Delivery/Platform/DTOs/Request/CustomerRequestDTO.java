package com.example.Food.Delivery.Platform.DTOs.Request;

import com.example.Food.Delivery.Platform.Enitity.Customer;
import com.example.Food.Delivery.Platform.Enitity.CustomerAddress;
import com.example.Food.Delivery.Platform.Utils.HelperUtils;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    private String AllCustomers;


    public static Customer toRequest(CustomerRequestDTO dto) {
        Customer customer = new Customer();

        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setPasswordHash(dto.getPasswordHash());

        return customer;
    }
}


