package com.umg.edu.manager.user;

import com.umg.edu.entity.User;
import com.umg.edu.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class UserManagerImpl implements UserManager{
    Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);

    private UserRepository  userRepository;
    @Override
    public User saveUser(User user) {
        logger.info("User saved {}", user);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        logger.info("Request update user by Id: {}", id);
        User messageUpdate = userRepository.findById(id).get();

        if(Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())){
            messageUpdate.setName(user.getName());
        }

        if(Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())){
            messageUpdate.setEmail(user.getEmail());
        }

        if(Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())){
            messageUpdate.setPassword(user.getPassword());
        }

        logger.info("User updated {}", messageUpdate);
        return userRepository.save(messageUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        logger.info("Request delete by Id {}", id);
        User user = userRepository.findById(id).orElseThrow(()->
                new RuntimeException("Message not found with Id: " + id));
        user.setStatus(false);
        logger.info("Message deleted {}", id);
        userRepository.save(user);
    }
}
