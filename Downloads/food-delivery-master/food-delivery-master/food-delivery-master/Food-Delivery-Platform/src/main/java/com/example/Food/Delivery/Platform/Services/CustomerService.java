package com.example.Food.Delivery.Platform.Services;

import com.example.Food.Delivery.Platform.DTOs.Request.CustomerAddressRequestDTO;
import com.example.Food.Delivery.Platform.DTOs.Request.CustomerRequestDTO;
import com.example.Food.Delivery.Platform.DTOs.Response.CustomerResponseDTO;
import com.example.Food.Delivery.Platform.Enitity.Customer;
import com.example.Food.Delivery.Platform.Enitity.CustomerAddress;
import com.example.Food.Delivery.Platform.Exception.ResourceNotFoundException;
import com.example.Food.Delivery.Platform.Repositories.CustomerAddressRepository;
import com.example.Food.Delivery.Platform.Repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private  CustomerRepository customerRepository;
    @Autowired
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
        address.setCustomer(customer);

        addressRepository.save(address);

        return customer;
    }

    @Transactional
    public void addAddress(Long customerId, CustomerAddressRequestDTO dto) {

        Customer customer = getActiveCustomer(customerId);

        CustomerAddress address = new CustomerAddress();
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setCustomer(customer);

        addressRepository.save(address);
    }

    @Transactional
    public void updateLoyaltyPoints(Long customerId, int points) {

        Customer customer = getActiveCustomer(customerId);
        customer.setLoyaltyPoints(customer.getLoyaltyPoints() + points);

        customerRepository.save(customer);
    }

    @Transactional
    public void applyLoyaltyPenalty(Long customerId, int pointsDeducted) {

        Customer customer = getActiveCustomer(customerId);

        int updated = Math.max(0, customer.getLoyaltyPoints() - pointsDeducted);
        customer.setLoyaltyPoints(updated);

        customerRepository.save(customer);
    }

    @Transactional
    public void deactivateCustomer(Long customerId) {

        Customer customer = getActiveCustomer(customerId);
        customer.setActive(false);

        customerRepository.save(customer);
    }

    private Customer getActiveCustomer(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        if (!customer.isActive()) {
            throw new RuntimeException("Customer is deactivated");
        }

        return customer;
    }

    private String generateCustomerCode() {
        return "CUST-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(c -> new CustomerResponseDTO(
                        c.getId(),
                        c.getFirstName(),
                        c.getLastName(),
                        c.getEmail(),
                        c.getPhone(),
                        c.getLoyaltyPoints(),
                        c.isActive(),
                        c.getCustomerCode()
                ))
                .toList();
    }
}