package com.grumble.mapper;

import com.grumble.entities.User;
import com.grumble.dto.UserDto;

public interface UserMapper {
    UserDto mapEntityToUser(User userEntity);
    User mapUserToEntity(UserDto userDto);
}
