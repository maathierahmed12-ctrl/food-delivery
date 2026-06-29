package com.example.Food.Delivery.Platform.DTOs.Response;

import com.example.Food.Delivery.Platform.Enitity.Customer;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddressResponseDTO {

    private Long id;

    private String  street ;

    private String city;

    private  String building;

    private Boolean isDefault ;

    private String address;




    public static CustomerAddressResponseDTO toResponse(Customer Customer) {

        CustomerAddressResponseDTO dto = new CustomerAddressResponseDTO();


        dto.setId(dto.getId());
        dto.setIsDefault(dto.getIsDefault());
        dto.setStreet(dto.getStreet());
        dto.setCity(dto.getCity());
        dto.setBuilding(dto.getBuilding());
        dto.setAddress(dto.getAddress());

        return dto;

    }

}
