package com.example.Food.Delivery.Platform.Services;

import com.example.Food.Delivery.Platform.Enitity.Review;
import com.example.Food.Delivery.Platform.Repositories.CustomerAddressRepository;
import com.example.Food.Delivery.Platform.Utils.HelperUtils;

public class ReviewService {

    @Autowired
    public ReviewService(ReviewService reviewService, CustomerService customerService,DeliveryService deliveryService)
    {
        this.ReviewService = reviewService;
        this.CustomerService = customerService;
        this.DeliveryService = deliveryService;


    }

    public Review processPayment(Integer orderId, String method){


    }
}
