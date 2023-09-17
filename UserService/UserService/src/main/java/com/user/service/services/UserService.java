package com.user.service.services;

import com.user.service.entities.User;

import java.util.List;

public interface UserService {

    // create user
    User createUser(User user);



    // delete user
    void deleteUser(String userId);

    //  update user
    User  updateUser(String userId,User user);


    // get all user

    List<User> getAllUsers();


    // get single user by id
    User getUserById(String userId);



    //
}
