package com.example.Food.Delivery.Platform.Exception;

public class InvalidOrderStateException extends RuntimeException {

    public InvalidOrderStateException(String Message) {
        super(Message);
    }

}

