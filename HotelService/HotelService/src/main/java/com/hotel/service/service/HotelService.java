package com.hotel.service.service;

import com.hotel.service.entities.Hotel;
import org.springframework.beans.support.PagedListHolder;

import java.util.List;

public interface HotelService {


    //  create hotel

    Hotel createHotel(Hotel hotel);


    // updateHotel

    Hotel updateHotel(String  hotelId,Hotel hotel);

    // delete Hotel
    void deleteHotel(String  hotelId);


    // get all hotesl

    List<Hotel>  getAllHotels();


    // get hotel by id

    Hotel getHotelById(String  hotelId);


}
