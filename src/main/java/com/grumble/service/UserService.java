package com.grumble.service;

import com.grumble.dto.UserDto;

public interface UserService {
    UserDto getUserById(Long id);
    UserDto createUser(UserDto userDtoToSave);
    Long deleteUserById(Long id);
    UserDto updateUser(UserDto userDtoUpdated);
}
