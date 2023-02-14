package com.system.powerup.services;

import com.system.powerup.Entity.User;
import com.system.powerup.pojo.UserPojo;

import java.util.List;
import java.util.Optional;


public interface UserService {
    String save(UserPojo userPojo) ;

    List<User> fetchAll();

    Optional<User> fetchById(Integer id);

    void deleteById(Integer id);

    void sendEmail();

    User findByEmail(String email);
}
