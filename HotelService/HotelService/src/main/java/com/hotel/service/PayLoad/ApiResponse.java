package com.hotel.service.PayLoad;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ApiResponse {

    private  String message;
    private Boolean success;
    private HttpStatus status;
}
