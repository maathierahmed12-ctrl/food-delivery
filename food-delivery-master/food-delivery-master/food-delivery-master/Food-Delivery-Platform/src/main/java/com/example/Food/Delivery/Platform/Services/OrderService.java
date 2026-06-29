package com.example.Food.Delivery.Platform.Services;

import com.example.Food.Delivery.Platform.DTOs.Request.CorporateOrderRequestDTO;
import com.example.Food.Delivery.Platform.DTOs.Request.OrderItemRequestDTO;
import com.example.Food.Delivery.Platform.Enitity.*;
import com.example.Food.Delivery.Platform.Repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private MenuItemRepository menuItemRepositories;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    public OrderService(OrderRepository orderRepository,
                        OrderItemRepository orderItemRepository,
                        MenuItemRepository menuItemRepositories,
                        CustomerRepository customerRepository,
                        RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.menuItemRepositories = menuItemRepositories;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
    }

    private Order findOrderById(Integer orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
    }

    public Order createOrder(Integer customerId, Integer restaurantId, List<OrderItemRequestDTO> items, String notes) {
        Order order = new Order();

        order.setStatus("PENDING");
        order.setNote(notes);

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        order.setCustomer(customer);
        order.setRestaurant(restaurant);

        Order savedOrder = orderRepository.save(order);

        for (OrderItemRequestDTO dto : items) {
            MenuItem menuItem = menuItemRepositories.findById(dto.getMenuItemId())
                    .orElseThrow(() -> new RuntimeException("MenuItem not found"));

            OrderItem item = new OrderItem();

            item.setMenuItem(menuItem);
            item.setQuantity(dto.getQuantity());
            item.setUnitPrice(menuItem.getPrice());
            item.setTotalPrice(menuItem.getPrice() * dto.getQuantity());

            orderItemRepository.save(item);
        }
        return savedOrder;
    }

    public void addMenuItemToOrder(Integer orderId, Integer menuItemId, int quantity) {
        Order order = findOrderById(orderId);

        MenuItem menuItem = menuItemRepositories.findById(menuItemId)
                .orElseThrow(() -> new RuntimeException("MenuItem not found"));

        OrderItem orderItem = new OrderItem();
        orderItem.setMenuItem(menuItem);
        orderItem.setQuantity(quantity);
        orderItem.setUnitPrice(menuItem.getPrice());
        orderItem.setTotalPrice(menuItem.getPrice() * quantity);

        orderItemRepository.save(orderItem);
    }

    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    public void applyDiscount(Integer orderId, double discountAmount) {
        Order order = findOrderById(orderId);
        order.setDiscountAmount(discountAmount);
        orderRepository.save(order);
    }

    public void updateOrderStatus(Integer orderId, String newStatus) {
        Order order = findOrderById(orderId);

        order.setStatus(newStatus);
        orderRepository.save(order);
    }

    public void cancelOrder(Integer orderId) {
        Order order = findOrderById(orderId);

        // FIX 3: Changed getOrderstatus to getStatus
        if (!"PENDING".equals(order.getStatus())) {
            throw new RuntimeException("InvalidOrderStateException");
        }

        // FIX 4: Changed setOrderstatus to setStatus
        order.setStatus("CANCELLED");
        orderRepository.save(order);
    }

    public double calculateOrderTotals(Integer orderId) {
        Order order = findOrderById(orderId);

        return order.getOrderItems()
                .stream()
                .mapToDouble(i -> i.getQuantity() * i.getUnitPrice())
                .sum();
    }

    public Order placeCorporateOrder(CorporateOrderRequestDTO dto) {
        Order order = new Order();

        order.setStatus(dto.getStatus() != null ? dto.getStatus() : "PENDING");
        order.setOrderDate(dto.getOrderDate());
        order.setOrderCode("CORPORATE");

        Order savedOrder = orderRepository.save(order);

        if (dto.getOrderItems() != null && !dto.getOrderItems().isEmpty()) {
            List<OrderItem> orderItemsList = new ArrayList<>();

            for (OrderItemRequestDTO itemDto : dto.getOrderItems()) {
                MenuItem menuItem = menuItemRepositories.findById(itemDto.getMenuItemId())
                        .orElseThrow(() -> new RuntimeException("MenuItem not found with ID: " + itemDto.getMenuItemId()));

                OrderItem orderItem = new OrderItem();
                orderItem.setMenuItem(menuItem);
                orderItem.setQuantity(itemDto.getQuantity());
                orderItem.setUnitPrice(menuItem.getPrice());
                orderItem.setTotalPrice(menuItem.getPrice() * itemDto.getQuantity());

                orderItemRepository.save(orderItem);

                orderItemsList.add(orderItem);
            }

            savedOrder.setOrderItems(orderItemsList);
        }

        return savedOrder;
    }
}