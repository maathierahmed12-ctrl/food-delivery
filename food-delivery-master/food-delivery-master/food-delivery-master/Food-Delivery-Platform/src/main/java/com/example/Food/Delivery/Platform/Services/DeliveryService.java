package com.example.Food.Delivery.Platform.Services;
import com.example.Food.Delivery.Platform.DTOs.Response.DeliveryResponseDTO;
import com.example.Food.Delivery.Platform.Enitity.Delivery;
import com.example.Food.Delivery.Platform.Enitity.DeliveryDriver;
import com.example.Food.Delivery.Platform.Enitity.Order;
import com.example.Food.Delivery.Platform.Exception.ResourceNotFoundException;
import com.example.Food.Delivery.Platform.Repositories.DeliveryDriverRepository;
import com.example.Food.Delivery.Platform.Repositories.DeliveryRepository;
import com.example.Food.Delivery.Platform.Repositories.DriverRepository;
import com.example.Food.Delivery.Platform.Repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private OrderRepository orderRepository;



    public DeliveryResponseDTO assignDriverToOrder(Integer orderId, Integer driverId){

        Order order=orderRepository.findById(orderId)
                .orElseThrow(()->new RuntimeException("Order not found"));
        Delivery delivery=new Delivery();
        delivery.setOrder(order);
        delivery.setId(delivery.getId());
        delivery.setStatus("ASSIGNED");
        delivery.setAssignedAt(LocalDateTime.now());

        return  DeliveryResponseDTO.toResponse((Delivery)deliveryRepository);
    }

    public Delivery autoAssignDriver(Integer orderId){

        Order order=orderRepository.findById(orderId)
                .orElseThrow(()->new RuntimeException("Order not found"));

        Driver driver=driverRepository.findFirstByOnlineTrueAndAvailableTrue()
                .orElseThrow(()->new RuntimeException("No available drivers"));

        Delivery delivery=new Delivery();
        delivery.setOrder(order);
        delivery.setDriver(((Delivery) driver).getDriver());
        delivery.setStatus("ASSIGNED");
        delivery.setAssignedAt(LocalDateTime.now());
        delivery.setActive(false);
        driverRepository.save(driver);
        return delivery;
    }

    public void updateDriverLocation(Integer driverId,double lat,double lng){

        Driver driver=driverRepository.findById((int) driverId.longValue())
                .orElseThrow(()->new RuntimeException("Driver not found"));

        Delivery delivery=new Delivery();
        delivery.setActive(true);
        delivery.setActive(false);
        driverRepository.save(driver);
    }


    public void markDeliveryPickedUp(Integer deliveryId){

        Delivery delivery= (Delivery) deliveryRepository.findById((deliveryId))
                .orElseThrow(()->new RuntimeException("Delivery not found"));

        delivery.setStatus("PICKED_UP");
        delivery.setPickedUpAt(LocalDateTime.now());

        Delivery delivery1 = new Delivery();
        delivery.setActive(delivery.isActive());
        delivery1.setStatus("PICKED_UP");
        delivery1.setPickedUpAt(LocalDateTime.now());
        deliveryRepository.findNearbyDeliveries(deliveryId);
    }

    public void markDeliveryDelivered(Integer deliveryId) {

        Delivery delivery = (Delivery) deliveryRepository.findById((deliveryId))
                .orElseThrow(() -> new RuntimeException("Delivery not found"));


        Delivery delivery1 = new Delivery();
        delivery.setStatus("DELIVERED");
        delivery.setDeliveredAt(LocalDateTime.now());

        Driver driver = (Driver) delivery.getDriver();
        if (driver != null) {
            delivery.setActive(true);
            driverRepository.save(driver);
        }

    }

    public List<Delivery> getDeliveriesForDriver(Integer driverId,String status){

        if(status==null){

            return deliveryRepository.findByDriver_Id(driverId);
        }

        return deliveryRepository.findByDriver_Id(driverId);
    }

    public void toggleDriverOnlineStatus(Integer driverId,boolean isOnline){

        Driver driver=driverRepository.findById(driverId)
                .orElseThrow(()->new ResourceNotFoundException("Driver not found"));
        Delivery delivery = new Delivery();

        delivery.setStatus("ONLINE");
        delivery.setActive(isOnline);

        if(!isOnline){
            delivery.setActive(false);

        }else{
            delivery.isActive();
        }

        driverRepository.save(driver);
    }
}