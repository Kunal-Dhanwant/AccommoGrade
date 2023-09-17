package com.user.service.Payload;


import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ApiResponse {

   private String message;
   private Boolean suuccess;
  private   HttpStatus status;

}
