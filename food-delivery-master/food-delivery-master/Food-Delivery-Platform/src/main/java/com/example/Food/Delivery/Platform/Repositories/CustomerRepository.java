package com.example.Food.Delivery.Platform.Repositories;
import com.example.Food.Delivery.Platform.Enitity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer,Long> {

    boolean existsByEmail(String email);

    Customer findByEmail(String email);

    Customer findByCustomerCode(String customerCode);

    @Query("""
        SELECT DISTINCT c
        FROM Customer c
        JOIN c.addresses a
        WHERE a.city = :city
    """)
    List<Customer> findByCity(@Param("city") String city);

}


