package com.grumble.controller;

import com.grumble.model.User;
import com.grumble.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        log.info("REST Resource called (user) = getUserById: {}", id);

        User user = userService.getUserById(id);

        if (null == user) {
            log.error("Unable to find user by id: {}", id);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Long> deleteUserById(@PathVariable Long id) {
        log.info("REST Resource called (user) - deleteUserById: {}", id);

        Long userId = userService.deleteUserById(id);

        if (null == userId) {
            log.error("Unable to delete user by id: {}", id);
            return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity<User> createUser(@RequestBody User userToCreate) {
        log.info("REST Resource called (user) - createUser");

        User user = userService.createUser(userToCreate);

        if (null == user) {
            log.error("Unable to create user");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("user")
    public ResponseEntity<User> updateUser(@RequestBody User userToUpdate) {
        log.info("REST Resource called - updateUser");

        User user = userService.updateUser(userToUpdate);

        if (null == user) {
            log.error("Failed to update user.");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
