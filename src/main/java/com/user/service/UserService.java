package com.user.service;

import com.user.entity.User;

public interface UserService {
    User save(User user);

    User findByUsername(String username);
}