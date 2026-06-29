package com.example.Food.Delivery.Platform.DTOs.Request;

import com.example.Food.Delivery.Platform.Enitity.Customer;
import com.example.Food.Delivery.Platform.Enitity.CustomerAddress;
import com.example.Food.Delivery.Platform.Utils.HelperUtils;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CustomerAddressRequestDTO {

    @NotBlank
    private String street;

    @NotBlank
    private String city;
    @NotBlank
    private String building;

    private Boolean isDefault;


    public static CustomerAddress toRequest(CustomerAddressRequestDTO dto) {
        CustomerAddress customerAddress = new CustomerAddress();

         customerAddress.setStreet(dto.getStreet());
         customerAddress.setCity(dto.getCity());
         customerAddress.setBuilding(dto.getBuilding());
         customerAddress.setDefault(false);
         customerAddress.setDefault(true);

        if (HelperUtils.isNull(customerAddress.getAddress())) {
            customerAddress.setCustomer(new Customer());
        }

        return customerAddress;
    }
}


