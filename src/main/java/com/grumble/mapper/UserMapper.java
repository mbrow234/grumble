package com.grumble.mapper;

import com.grumble.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    private AddressMapper addressMapper;

    @Autowired
    public UserMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public User mapEntityToUser(com.grumble.entities.User userEntity) {
        User user = new User();

        user.setId(userEntity.getId());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setAddress(addressMapper.mapEntityToAddress(userEntity.getAddress()));
        user.setUserSince(userEntity.getUserSince());

        return user;
    }

    public com.grumble.entities.User mapUserToEntity(User user) {
        com.grumble.entities.User userEntity = new com.grumble.entities.User();

        userEntity.setId(user.getId());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setUserSince(user.getUserSince());
        userEntity.setAddress(addressMapper.mapAddressToEntity(user.getAddress()));

        return userEntity;
    }

}
