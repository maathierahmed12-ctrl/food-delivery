package com.example.Food.Delivery.Platform.Exception;

import org.apache.logging.log4j.message.Message;

public class ResourceNotFoundException extends RuntimeException  {

    public ResourceNotFoundException(String Message) {
        super(Message);
    }
}

