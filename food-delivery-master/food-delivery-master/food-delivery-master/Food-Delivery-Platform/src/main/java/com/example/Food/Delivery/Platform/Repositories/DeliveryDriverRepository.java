package com.example.Food.Delivery.Platform.Repositories;

import com.example.Food.Delivery.Platform.DTOs.Request.DeliveryDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.sql.Driver;
import java.util.List;

@Repository
public interface DeliveryDriverRepository extends JpaRepository<DeliveryDriver,Integer> {

    @Query("SELECT e FROM DeliveryDriver e " +
            "WHERE e.DeliveryDriver = :value AND e.isActive = true")
    List<DeliveryDriver> exampleLookup(@Param("value") String value);

    List<DeliveryDriver> findNearbyDrivers(
            @Param("lat") double lat,
            @Param("lng") double lng,
            @Param("radiusKm") double radiusKm
    );
    List<Driver> findFirstByIsOnlineTrueAndIsAvailableTrue();

}







