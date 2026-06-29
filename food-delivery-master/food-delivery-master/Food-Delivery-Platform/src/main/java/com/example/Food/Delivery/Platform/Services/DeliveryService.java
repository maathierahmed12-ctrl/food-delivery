package com.example.Food.Delivery.Platform.Services;

import com.example.Food.Delivery.Platform.Enitity.Delivery;
import com.example.Food.Delivery.Platform.Enitity.Order;
import com.example.Food.Delivery.Platform.Repositories.DeliveryRepositories;
import com.example.Food.Delivery.Platform.Repositories.OrderRepositories;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;



@Service
public class DeliveryService {

    private DeliveryRepositories deliveryRepositories;
    private OrderRepositories orderRepositories;

    public DeliveryService(DeliveryRepositories deliveryRepositories, OrderRepositories orderRepositories) {

        this.deliveryRepositories = deliveryRepositories;
        this.orderRepositories = orderRepositories;

    }

        @Transactional

        public void assignDriverToOrder(Integer orderId, Integer driverId){

            Order order = OrderRepositories.findById(orderId)
                    .orElseThrow(()-> new RuntimeException("Driver not found");
        }
     @Transactional

    public   Delivery autoAssignDriver(Integer orderId) {

     }

     @Transactional

    public Delivery updateDriverLocation(Integer driverId, double lat, double lng){


     }

     @Transactional

    public Delivery  markDeliveryPickedUp(Integer deliveryId){


     }

     @Transactional

    public Delivery markDeliveryDelivered(Integer deliveryId){


     }

     @Transactional

    public Delivery  getDeliveriesForDriver(Integer driverId, String status){

     }

     @Transactional

    public Delivery toggleDriverOnlineStatus(Integer driverId, boolean isOnline){

     }
}

