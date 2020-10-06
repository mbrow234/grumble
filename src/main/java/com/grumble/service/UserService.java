package com.grumble.service;

import com.grumble.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto createUser(UserDto userDtoToSave);
    Long deleteUserById(Long id);
    UserDto updateUser(UserDto userDtoUpdated);
}
