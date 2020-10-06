package com.grumble.service.impl;

import com.grumble.entities.User;
import com.grumble.mapper.UserMapper;
import com.grumble.dto.UserDto;
import com.grumble.repository.UserRepository;
import com.grumble.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto getUserById(Long id) {
        Optional<User> userEntity = userRepository.findById(id);
        UserDto userDto;
        if (userEntity.isPresent()) {
            userDto = userMapper.mapEntityToUser(userEntity.get());
        } else {
            return null;
        }

        return userDto;
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        userRepository.findAll().forEach(user -> userDtos.add(userMapper.mapEntityToUser(user)));
        return userDtos;
    }

    public UserDto createUser(UserDto userDtoToSave) {
        User savedUser;

        try {
            savedUser = userRepository.save(userMapper.mapUserToEntity(userDtoToSave));
        } catch (Exception e) {
            return null;
        }

        return userMapper.mapEntityToUser(savedUser);
    }

    public Long deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            return null;
        }

        return id;
    }

    public UserDto updateUser(UserDto userDtoUpdated) {
        UserDto userDto = userMapper.mapEntityToUser(userRepository.save(userMapper.mapUserToEntity(userDtoUpdated)));

        return userDto;
    }

}
