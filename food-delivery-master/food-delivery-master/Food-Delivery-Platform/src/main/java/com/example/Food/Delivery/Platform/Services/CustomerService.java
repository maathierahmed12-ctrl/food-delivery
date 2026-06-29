package com.example.Food.Delivery.Platform.Services;

import com.example.Food.Delivery.Platform.DTOs.Request.CustomerAddressRequestDTO;
import com.example.Food.Delivery.Platform.DTOs.Request.CustomerRequestDTO;
import com.example.Food.Delivery.Platform.Enitity.Customer;
import com.example.Food.Delivery.Platform.Enitity.CustomerAddress;
import com.example.Food.Delivery.Platform.Repositories.CustomerAddressRepository;
import com.example.Food.Delivery.Platform.Repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CustomerService  {

    private  CustomerRepository customerRepository;
    private  CustomerAddressRepository addressRepository;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerAddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public Customer createCustomer(CustomerRequestDTO dto) {

        if (customerRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setPasswordHash(dto.getPasswordHash());
        customer.setLoyaltyPoints(0);
        customer.setCustomerCode(generateCustomerCode());
        customer.setActive(true);

        return customerRepository.save(customer);
    }

    @Transactional
    public Customer createCustomer(CustomerRequestDTO dto,
                                   CustomerAddressRequestDTO addressDto) {

        Customer customer = createCustomer(dto);

        CustomerAddress address = new CustomerAddress();
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setCity(addressDto.getCity());
        address.setCustomer(customer);

        addressRepository.save(address);

        return customer;
    }

    @Transactional
    public CustomerAddress addAddress(Long customerId,
                                      CustomerAddressRequestDTO dto) {

        Customer customer = getActiveCustomer(customerId);

        CustomerAddress address = new CustomerAddress();
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setCity(dto.getCity());
        address.setCustomer(customer);

        return addressRepository.save(address);
    }

    @Transactional
    public void updateLoyaltyPoints(Integer customerId, int points) {

        Customer customer = getActiveCustomer(customerId.longValue());
        customer.setLoyaltyPoints(customer.getLoyaltyPoints() + points);

        customerRepository.save(customer);
    }

    @Transactional
    public void applyLoyaltyPenalty(Integer customerId, int pointsDeducted) {

        Customer customer = getActiveCustomer(customerId.longValue());

        int updated = Math.max(0, customer.getLoyaltyPoints() - pointsDeducted);
        customer.setLoyaltyPoints(updated);

        customerRepository.save(customer);
    }

    @Transactional
    public void deactivateCustomer(Integer customerId) {

        Customer customer = getActiveCustomer(customerId.longValue());
        customer.setActive(false);

        customerRepository.save(customer);
    }

    private Customer getActiveCustomer(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (!customer.isActive()) {
            throw new RuntimeException("Customer is deactivated");
        }

        return customer;
    }

    private String generateCustomerCode() {
        return "CUST-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}