package com.example.Food.Delivery.Platform.DTOs.Response;

import com.example.Food.Delivery.Platform.Enitity.Customer;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

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

    private LocalDateTime updatedAt;

    private  String AllCustomers;

    private String deactivateCustomer;

    private String Alladdress;

    public CustomerResponseDTO(Integer id, String firstName, String lastName, String email, String phone, int loyaltyPoints, boolean active, String customerCode) {
    }

    public static CustomerResponseDTO toResponse(Customer Customer) {

        CustomerResponseDTO dto = new CustomerResponseDTO();

        dto.setId(Customer.getId());
        dto.setFirstName(Customer.getFirstName());
        dto.setLastName(Customer.getLastName());
        dto.setEmail(Customer.getEmail());
        dto.setPhone(Customer.getPhone());
        dto.setCustomerCode(Customer.getCustomerCode());
        dto.setLoyaltyPoints(Customer.getLoyaltyPoints());
        dto.setActive(Customer.isActive());
        dto.setCreatedAt(LocalDateTime.now());
        dto.setUpdatedAt(LocalDateTime.now());
        dto.setAllCustomers(dto.getAllCustomers());
        dto.setDeactivateCustomer(dto.getDeactivateCustomer());
        dto.setAlladdress(dto.getAlladdress());



        return dto;

    }

}






