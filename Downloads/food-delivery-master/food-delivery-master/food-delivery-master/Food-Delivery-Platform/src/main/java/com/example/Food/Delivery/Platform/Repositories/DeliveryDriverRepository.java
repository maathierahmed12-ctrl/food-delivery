package com.example.Food.Delivery.Platform.Repositories;

import com.example.Food.Delivery.Platform.DTOs.Request.DeliveryDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Driver;
import java.util.List;

@Repository
public interface DeliveryDriverRepository extends JpaRepository<DeliveryDriver,Long> {

    List<Driver> findFirstByIsOnlineTrueAndIsAvailableTrue();

    @Query("UPDATE DeliveryDriver d SET d.latitude = :lat, d.longitude = :lng WHERE d.id = :id")
    int updateLocationDirectly(@Param("id") Long id, @Param("lat") double lat, @Param("lng") double lng);
}



