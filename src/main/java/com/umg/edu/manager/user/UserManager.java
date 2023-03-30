package com.umg.edu.manager.user;

import com.umg.edu.entity.User;

public interface UserManager {
    User saveUser(User user);

    User updateUser(User user, Long id);

    void deleteUser(Long id);
}