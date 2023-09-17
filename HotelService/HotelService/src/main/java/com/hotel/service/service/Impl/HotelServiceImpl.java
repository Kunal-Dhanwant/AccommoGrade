package com.hotel.service.service.Impl;

import com.hotel.service.Exception.ResourceNotFoundException;
import com.hotel.service.Repo.HotelRepository;
import com.hotel.service.entities.Hotel;
import com.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {

        String  hotelid= UUID.randomUUID().toString();
        hotel.setHotelId(hotelid);
        Hotel hotel1 =  hotelRepository.save(hotel);

        return hotel1;
    }

    @Override
    public Hotel updateHotel(String hotelId, Hotel hotel) {

        Hotel hotel1 = hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("hotel with given id doest not exist"));

        hotel1.setName(hotel.getName());
        hotel1.setAbout(hotel.getAbout());
        hotel1.setStar(hotel1.getStar());
        hotel1.setAddress(hotel.getAddress());

        Hotel  updatedHotel = hotelRepository.save(hotel1);




        return updatedHotel;
    }

    @Override
    public void deleteHotel(String hotelId) {
        Hotel hotel1 = hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("hotel with given id doest not exist"));

        hotelRepository.delete(hotel1);


    }

    @Override
    public List<Hotel> getAllHotels() {

        List<Hotel> hotels = hotelRepository.findAll();

        return hotels;
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        Hotel hotel1 = hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("hotel with given id doest not exist"));


        return hotel1;
    }
}
