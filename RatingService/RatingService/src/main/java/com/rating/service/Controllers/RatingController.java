package com.rating.service.Controllers;


import com.rating.service.entities.Rating;
import com.rating.service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {


    @Autowired
    private RatingService ratingService;


    @PostMapping()
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){

        Rating savedRating = ratingService.createRating(rating);

        return  new ResponseEntity<>(rating, HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity<List<Rating>> getAllRatings(){

        List<Rating>  ratings = ratingService.getAllRatings();

        return  new ResponseEntity<>(ratings,HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUser(@PathVariable String  userId){

        List<Rating>  ratings = ratingService.getAllRatingsOfUser(userId);

        return  new ResponseEntity<>(ratings,HttpStatus.OK);
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsOsHotel(@PathVariable String  hotelId){

        List<Rating>  ratings = ratingService.getAllRatingsOfAHotel(hotelId);

        return  new ResponseEntity<>(ratings,HttpStatus.OK);
    }






}
