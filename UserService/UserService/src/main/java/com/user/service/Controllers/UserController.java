package com.user.service.Controllers;


import com.user.service.Payload.ApiResponse;
import com.user.service.entities.User;
import com.user.service.services.UserService;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    // create user
    @PostMapping
    public ResponseEntity<User>  createUser(@RequestBody User user){

      User savedUser=  userService.createUser(user);
      return new ResponseEntity<>(savedUser, HttpStatus.CREATED);


    }

    //  update user

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String userId){

        User updatedUser = userService.updateUser(userId, user);

        return new ResponseEntity<>(updatedUser,HttpStatus.OK);




    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse>  deleteUser( @PathVariable String userId){

        userService.deleteUser(userId);

        ApiResponse response = ApiResponse.builder()
                .message("user deleted successfully")
                .suuccess(true)
                .status(HttpStatus.OK)
                .build();

        return  new ResponseEntity<>(response,HttpStatus.OK);

    }

    // get all users

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users,HttpStatus.OK);


    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){

        User user1 = userService.getUserById(userId);

        return new ResponseEntity<>(user1,HttpStatus.OK);
    }





}
