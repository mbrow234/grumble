package com.grumble.controller;

import com.grumble.dto.UserDto;
import com.grumble.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        log.info("REST Resource called (userDto) = getUserById: {}", id);

        UserDto userDto = userService.getUserById(id);

        if (null == userDto) {
            log.error("Unable to find userDto by id: {}", id);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("user")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        log.info("REST Resource called - getAllUsers");

        List<UserDto> userDtos = userService.getAllUsers();
        if (CollectionUtils.isEmpty(userDtos)) {
            log.warn("Failed to get all users or there were none.");
            return new ResponseEntity<>(userDtos, HttpStatus.GONE);
        }

        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Long> deleteUserById(@PathVariable Long id) {
        log.info("REST Resource called (user) - deleteUserById: {}", id);

        Long userId = userService.deleteUserById(id);

        if (null == userId) {
            log.warn("Unable to delete user by id: {}", id);
            return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDtoToCreate) {
        log.info("REST Resource called (userDto) - createUser");

        UserDto userDto = userService.createUser(userDtoToCreate);

        if (null == userDto) {
            log.error("Unable to create userDto");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping("user")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDtoToUpdate) {
        log.info("REST Resource called - updateUser");

        UserDto userDto = userService.updateUser(userDtoToUpdate);

        if (null == userDto) {
            log.error("Failed to update userDto.");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("user/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        log.info("REST Resource called - getUserByEmail: {}", email);

        UserDto userDto = userService.getUserByEmail(email);

        if (null == userDto) {
            log.warn("Unable to find user by email: {}", email);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
