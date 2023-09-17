package com.rating.service.service;

import com.rating.service.entities.Rating;

import java.util.List;
import java.util.UUID;

public interface RatingService {


    // create rating

    Rating createRating(Rating rating);


    //  get all rating

    List<Rating>  getAllRatings();



    //  get all ratings of user

    List<Rating> getAllRatingsOfUser(String userId);

    // get rating of a given hotel
    List<Rating> getAllRatingsOfAHotel(String hotelId);





}
