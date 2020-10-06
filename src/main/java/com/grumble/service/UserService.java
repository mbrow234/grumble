package com.grumble.service;

import com.grumble.model.User;

public interface UserService {
    User getUserById(Long id);
    User createUser(User userToSave);
    Long deleteUserById(Long id);
    User updateUser(User userUpdated);
}
