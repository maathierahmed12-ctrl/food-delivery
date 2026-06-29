package com.example.Food.Delivery.Platform.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Driver;
import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    List<Driver> findByOnlineTrue();

    List<Driver> findByAvailableTrue();

    @Query("""
        SELECT d FROM Driver d
        WHERE d.online = true
        AND d.available = true
    """)
    List<Driver> findAllAvailableDrivers();

    Optional<Driver> findByPhone(String phone);

    @Query("""
        SELECT d FROM Driver d
        WHERE d.online = true
    """)
    List<Driver> findOnlineDrivers();

    Optional<Driver> findFirstByOnlineTrueAndAvailableTrue();

    @Query("""
        UPDATE Driver d 
        SET d.online = :isOnline 
        WHERE d.id = :driverId
    """)
    int toggleDriverOnlineStatus(@Param("driverId") Integer driverId, @Param("isOnline") boolean isOnline);
}

