package com.user.service.exceptions;

import lombok.Builder;

@Builder
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {

        super("Resource is not found");
    }
    public ResourceNotFoundException(String message) {

        super(message);
    }


}
