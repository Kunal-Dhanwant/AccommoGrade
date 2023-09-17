package com.hotel.service.Controllers;

import com.hotel.service.PayLoad.ApiResponse;
import com.hotel.service.entities.Hotel;
import com.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {


    @Autowired
    private HotelService hotelService;


    //  crate hotel

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

        Hotel savedHotel = hotelService.createHotel(hotel);

        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }


    //  DELETE Hotel
    @DeleteMapping("/{hotelId}")

    public ResponseEntity<ApiResponse> deleteHotel(@PathVariable String hotelId){

        hotelService.deleteHotel(hotelId);

        ApiResponse response = ApiResponse.builder()
                .message("Hotel Deleted successfully")
                .success(true)
                .status(HttpStatus.OK)
                .build();

        return  new ResponseEntity<>(response,HttpStatus.OK);
    }

    //  get all hotels

    @GetMapping
    public  ResponseEntity<List<Hotel>>  getAllHotels(){

        List<Hotel> hotels =  hotelService.getAllHotels();

        return new ResponseEntity<>(hotels,HttpStatus.OK);


    }

    @GetMapping("/{hotelId}")
    public  ResponseEntity<Hotel> getHotelById(@PathVariable String  hotelId){

        Hotel hotel = hotelService.getHotelById(hotelId);

        return  new ResponseEntity<>(hotel,HttpStatus.OK);


    }

    //update hotel

    @PutMapping("/{hotelId}")

    public  ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel,@PathVariable String  hotelId){

        Hotel updatedHotyel = hotelService.updateHotel(hotelId,hotel);

        return  new ResponseEntity<>(updatedHotyel,HttpStatus.OK);
    }




}
