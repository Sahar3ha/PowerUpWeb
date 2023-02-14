package com.system.powerup.services.impl;

import com.system.powerup.Entity.User;
import com.system.powerup.pojo.UserPojo;

import com.system.powerup.repo.UserRepo;
import com.system.powerup.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;


    @Override
    public String save(UserPojo userPojo) {
        return null;
    }

    @Override
    public List<User> fetchAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> fetchById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void sendEmail() {

    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}

