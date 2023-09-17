package com.hotel.service.Exception;

import lombok.Builder;

@Builder
public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException() {

        super("Resource is not found");
    }
    public ResourceNotFoundException(String message) {

        super(message);
    }


}
