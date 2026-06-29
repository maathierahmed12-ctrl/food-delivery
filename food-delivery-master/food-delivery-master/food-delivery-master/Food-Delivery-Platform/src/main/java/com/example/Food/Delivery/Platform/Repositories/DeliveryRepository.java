package com.example.Food.Delivery.Platform.Repositories;
import com.example.Food.Delivery.Platform.Enitity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

        List<Delivery> findByDriver_Id(Integer driverId);

        @Query("SELECT d FROM Delivery d " +
                "WHERE d.isActive = true " +
                "AND d.latitude BETWEEN :minLat AND :maxLat " +
                "AND d.longitude BETWEEN :minLng AND :maxLng")
        List<Delivery> findNearbyApprox(
                @Param("minLat") double minLat,
                @Param("maxLat") double maxLat,
                @Param("minLng") double minLng,
                @Param("maxLng") double maxLng
        );

        @Query("SELECT d FROM Delivery d WHERE " +
                "(6371 * acos(cos(radians(:lat)) * cos(radians(d.latitude)) * " +
                "cos(radians(d.longitude) - radians(:lng)) + " +
                "sin(radians(:lat)) * sin(radians(d.latitude)))) <= :radius")
        List<Delivery> findNearbyDeliveries(
                @Param("lat") double lat,
                @Param("lng") double lng,
                @Param("radius") double radius
        );

          List<Delivery> findNearbyDeliveries(double lat);

}