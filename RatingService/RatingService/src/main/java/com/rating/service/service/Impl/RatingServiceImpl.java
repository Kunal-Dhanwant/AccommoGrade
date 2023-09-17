package com.rating.service.service.Impl;


import com.rating.service.entities.Rating;
import com.rating.service.repo.RatingRepository;
import com.rating.service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating createRating(Rating rating) {

        String  id = UUID.randomUUID().toString();
        rating.setRatingId(id);

       Rating savedrating= ratingRepository.save(rating);

        return  savedrating;
    }

    @Override
    public List<Rating> getAllRatings() {

        List<Rating>  ratings = ratingRepository.findAll();

        return ratings;
    }

    @Override
    public List<Rating> getAllRatingsOfUser(String userId) {
        List<Rating>  ratings = ratingRepository.findByUserId(userId);

        return ratings;
    }

    @Override
    public List<Rating> getAllRatingsOfAHotel(String hotelId) {
        List<Rating>  ratings = ratingRepository.findByHotelId(hotelId);

        return ratings;
    }
}
