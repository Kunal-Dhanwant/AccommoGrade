package com.user.service.services.Impl;

import com.user.service.entities.Hotel.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.external.service.HotelService;
import com.user.service.repo.UserRepository;
import com.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelService hotelService;


    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User createUser(User user) {

        String id = UUID.randomUUID().toString();
        user.setUserId(id);
        User savedUser=   userRepository.save(user);
         return  savedUser;




    }

    @Override
    public void deleteUser(String userId) {

        User user = userRepository.findById(userId).orElseThrow(()->  new ResourceNotFoundException("user with given id  doest not exist"));

        userRepository.delete(user);


    }

    @Override
    public User updateUser(String userId, User user) {
        User user1 = userRepository.findById(userId).orElseThrow(()->  new ResourceNotFoundException("user with given id  doest not exist"));

        user1.setAbout(user.getAbout());
        user1.setPassword(user.getPassword());
        user1.setName(user.getName());

        User savedUser = userRepository.save(user1);

        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {

        List<User>  users = userRepository.findAll();
        return users;
    }

    @Override
    public User getUserById(String userId) {

        User user1 = userRepository.findById(userId).orElseThrow(()->  new ResourceNotFoundException("user with given id  doest not exist"));


        //  featch rating of this user  with the help of  restTempalet or
        // by communicating with Rating service

       Rating[] ratingsOfUSERrarray= restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user1.getUserId(), Rating[].class);

       List<Rating>  ratingsOfUSER = Arrays.stream(ratingsOfUSERrarray).toList();

        List<Rating> ratings = ratingsOfUSER.stream().map(rating -> {
           // fetch the hotel of that given rating by commnicating with hotel service

        //    ResponseEntity<Hotel> forentity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);

            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;


        }).collect(Collectors.toList());


        user1.setRatings(ratings);
        return user1;
    }
}
