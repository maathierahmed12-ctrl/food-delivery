package com.example.Food.Delivery.Platform.DTOs.Request;

import com.example.Food.Delivery.Platform.Enitity.Customer;
import com.example.Food.Delivery.Platform.Enitity.CustomerAddress;
import com.example.Food.Delivery.Platform.Enitity.Delivery;
import com.example.Food.Delivery.Platform.Utils.HelperUtils;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DeliveryRequestDTO {

    private String trackingCode;

    private String status;

    private Long deliveryDriverId;


      public static Delivery toRequest(DeliveryRequestDTO deliveryRequestDTO) {

          DeliveryRequestDTO DeliveryRequestDTO = new DeliveryRequestDTO();

          DeliveryRequestDTO.setTrackingCode(deliveryRequestDTO.getTrackingCode());
          DeliveryRequestDTO.setStatus(deliveryRequestDTO.getStatus());
          DeliveryRequestDTO.setDeliveryDriverId(deliveryRequestDTO.getDeliveryDriverId());

          return null;
      }

    }


