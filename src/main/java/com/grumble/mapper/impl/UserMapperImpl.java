package com.grumble.mapper.impl;

import com.grumble.entities.User;
import com.grumble.mapper.UserMapper;
import com.grumble.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {

    private AddressMapperImpl addressMapper;

    @Autowired
    public UserMapperImpl(AddressMapperImpl addressMapper) {
        this.addressMapper = addressMapper;
    }

    public UserDto mapEntityToUser(User userEntity) {
        UserDto userDto = new UserDto();

        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setAddressDto(addressMapper.mapEntityToAddress(userEntity.getAddress()));
        userDto.setUserSince(userEntity.getUserSince());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPhone(userEntity.getPhone());

        return userDto;
    }

    public User mapUserToEntity(UserDto userDto) {
        User userEntity = new User();

        userEntity.setId(userDto.getId());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setUserSince(userDto.getUserSince());
        userEntity.setAddress(addressMapper.mapAddressToEntity(userDto.getAddressDto()));
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPhone(userDto.getPhone());

        return userEntity;
    }

}
