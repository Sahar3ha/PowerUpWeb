package com.system.powerup.services;

import com.system.powerup.Entity.SignUp;
import com.system.powerup.dto.SignUpDto;
import com.system.powerup.pojo.SignUpPojo;

import java.io.IOException;
import java.util.List;


public interface SignUpService {
    SignUpDto saveUser(SignUpDto signUpDto)throws IOException;
    SignUpPojo updateUser(SignUpPojo signUpPojo)throws IOException;
    SignUp fetchByEmail(String email);

    List<SignUp> fetchAll();
    SignUp fetchById(Integer id);

    void deleteById(Integer id);

}
