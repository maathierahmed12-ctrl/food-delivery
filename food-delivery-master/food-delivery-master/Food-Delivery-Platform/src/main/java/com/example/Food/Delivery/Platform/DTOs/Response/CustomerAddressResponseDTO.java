package com.example.Food.Delivery.Platform.DTOs.Response;

import lombok.*;

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
}
