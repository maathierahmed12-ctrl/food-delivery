package com.example.Food.Delivery.Platform.Exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Map;

@Builder
@Setter
@Getter
public class ErrorResponse  {


    private LocalDateTime timestamp;

    private int status;

    private String error;

    private String message;

    private String path;

    private Map<String, String> fieldErrors;
}