package com.example.Food.Delivery.Platform.Repositories;
import com.example.Food.Delivery.Platform.Enitity.Customer;
import com.example.Food.Delivery.Platform.Enitity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Integer> {

    @Query("""
        SELECT DISTINCT ca.customer
        FROM CustomerAddress ca
        WHERE ca.city = :city
        AND ca.isDefault = true
    """)
    List<Customer> findCustomersByCity(@Param("city") String city);

    @Query("""
        SELECT ca
        FROM CustomerAddress ca
        WHERE ca.id = :id
        AND ca.isDefault = true
    """)
    Optional<CustomerAddress> findDefaultById(@Param("id") Integer id);

    List<CustomerAddress> findByCustomerId(Integer customerId);

    List<CustomerAddress> findByCustomerIdAndIsDefaultTrue(Integer customerId);
}

