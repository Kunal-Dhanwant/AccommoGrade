package com.user.service.entities;


import com.user.service.entities.Hotel.Hotel;
import lombok.*;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmOneToManyCollectionElementType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Rating {

    private String ratingId;
    private  String userId;
    private  String hotelId;
    private String feednack;
    private  int rating;
    private Hotel hotel;
}
