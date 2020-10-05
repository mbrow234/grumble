package com.grumble.service;

import com.grumble.mapper.UserMapper;
import com.grumble.model.Address;
import com.grumble.model.User;
import com.grumble.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User getUserById(Long id) {
        Optional<com.grumble.entities.User> userEntity = userRepository.findById(id);
        User user;
        if (userEntity.isPresent()) {
            user = userMapper.mapEntityToUser(userEntity.get());
        } else {
            //TODO throw some error
            return null;
        }

        return user;
    }

    public User createUser(User userToSave) {
        com.grumble.entities.User savedUser = userRepository.save(userMapper.mapUserToEntity(userToSave));

        return userMapper.mapEntityToUser(savedUser);
    }

    public Long deleteUserById(Long id) {
        //TODO: delete user from mysql database and return the id of the one deleted

        return id;
    }

}
