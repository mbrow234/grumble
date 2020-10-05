package com.grumble.service;

import com.grumble.model.Address;
import com.grumble.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    //...

    public UserService() {
        //...
    }

    public User getUserById(Long id) {
        //TODO: get the user by id from mysql database

        return new User("Zoey", "Brown", "10-5-2020", new Address("11122 South 3452 West", "HappyVille", "84897", "UT", "USA"), null);
    }

    public User createUser(User userToSave) {
        //TODO save user to mysql database

        return userToSave;
    }

    public Long deleteUserById(Long id) {
        //TODO: delete user from mysql database and return the id of the one deleted

        return id;
    }

}
