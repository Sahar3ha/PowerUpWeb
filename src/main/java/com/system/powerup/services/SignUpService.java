package com.system.powerup.services;

import com.system.powerup.Entity.SignUp;
import com.system.powerup.pojo.SignUpPojo;

import java.io.IOException;


public interface SignUpService {
    String saveUser(SignUpPojo signUpPojo);

    SignUp fetchByEmail(String email);

//    List <SignUp> fetchAll();
//
    SignUp fetchById(Integer id);

    void deleteById(Integer id);
}
