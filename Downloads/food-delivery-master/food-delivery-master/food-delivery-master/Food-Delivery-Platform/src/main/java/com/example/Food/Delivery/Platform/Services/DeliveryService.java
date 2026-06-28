package com.example.Food.Delivery.Platform.Services;
import com.example.Food.Delivery.Platform.DTOs.Response.DeliveryResponseDTO;
import com.example.Food.Delivery.Platform.Enitity.Delivery;
import com.example.Food.Delivery.Platform.Enitity.DeliveryDriver;
import com.example.Food.Delivery.Platform.Enitity.Order;
import com.example.Food.Delivery.Platform.Exception.ResourceNotFoundException;
import com.example.Food.Delivery.Platform.Repositories.DeliveryDriverRepository;
import com.example.Food.Delivery.Platform.Repositories.DeliveryRepository;
import com.example.Food.Delivery.Platform.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DeliveryDriverRepository deliveryDriverRepository;

    @Autowired
    private OrderRepository orderRepository;

    public DeliveryResponseDTO assignDriverToOrder(Long orderId, Long driverId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        DeliveryDriver driver = deliveryDriverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + driverId));

        Delivery delivery = new Delivery();
        delivery.setOrder(order);
        delivery.setDriver(driver);
        delivery.setStatus("ASSIGNED");
        delivery.setAssignedAt(LocalDateTime.now());

        driver.setOnline(false);
        deliveryDriverRepository.save(driver);

        Delivery savedDelivery = deliveryRepository.save(delivery);
        return DeliveryResponseDTO.toResponse(savedDelivery);
    }

    public DeliveryResponseDTO autoAssignDriver(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        DeliveryDriver driver = deliveryDriverRepository.findFirstByIsOnlineTrueAndIsAvailableTrue()
                .orElseThrow(() -> new RuntimeException("No available drivers currently"));

        Delivery delivery = new Delivery();
        delivery.setOrder(order);
        delivery.setDriver(driver);
        delivery.setStatus("ASSIGNED");
        delivery.setAssignedAt(LocalDateTime.now());

        driver.setIsAvailable(false);

        deliveryDriverRepository.save(driver);

        Delivery savedDelivery = deliveryRepository.save(delivery);
        return DeliveryResponseDTO.toResponse(savedDelivery);
    }

    public void updateDriverLocation(Long driverId, double lat, double lng) {
        DeliveryDriver driver = deliveryDriverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        driver.setLatitude(lat);
        driver.setLongitude(lng);
        deliveryDriverRepository.save(driver);
    }

    public void markDeliveryPickedUp(Long deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));

        delivery.setStatus("PICKED_UP");
        delivery.setPickedUpAt(LocalDateTime.now());
        deliveryRepository.save(delivery);
    }

    public void markDeliveryDelivered(Long deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));

        delivery.setStatus("DELIVERED");
        delivery.setDeliveredAt(LocalDateTime.now());
        deliveryRepository.save(delivery);

        DeliveryDriver driver = delivery.getDriver();
        if (driver != null) {
            driver.setOnline(true);
            deliveryDriverRepository.save(driver);
        }
    }

       public List<Delivery> getDeliveriesForDriver(Long driverId, String status) {
        if (status == null) {
            return deliveryRepository.findByDriverId(driverId);
        }
        return deliveryRepository.findByDriverIdAndStatus(driverId, status);
    }

    public void toggleDriverOnlineStatus(Long driverId, boolean isOnline) {

        DeliveryDriver driver = deliveryDriverRepository.findById(driverId)
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with ID: " + driverId));

        driver.setOnline(isOnline);
        deliveryDriverRepository.save(driver);
    }
}