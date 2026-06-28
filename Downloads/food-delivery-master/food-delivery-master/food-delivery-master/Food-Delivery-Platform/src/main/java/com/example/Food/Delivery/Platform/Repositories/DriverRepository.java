package com.example.Food.Delivery.Platform.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Driver;
import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    List<Driver> findFirstByIsOnlineTrueAndIsAvailableTrue();

    List<Driver> findByIsOnlineTrue();

    List<Driver> findByIsAvailableTrue();

    @Query("""
        SELECT d FROM Driver d
        WHERE d.IsOnline = true
        AND d.isAvailable = true
    """)
    List<Driver> findAllAvailableDrivers();

    Optional<Driver> findByPhone(String phone);

    @Query("""
        SELECT d FROM Driver d
        WHERE d.isOnline = true
    """)
    List<Driver> findOnlineDrivers();
    List<Driver>toggleDriverOnlineStatus(Long driverId, boolean isOnline);
}

