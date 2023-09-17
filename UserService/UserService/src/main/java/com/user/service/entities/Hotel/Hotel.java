package com.user.service.entities.Hotel;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table
public class Hotel {
    @Id
    private  String hotelId;
    private  String name;
    private String address;
    private String about;
    private  int star;


}
