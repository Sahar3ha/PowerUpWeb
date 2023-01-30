//package com.system.powerup.services.impl;
//
//import com.system.powerup.Entity.Login;
//import com.system.powerup.exception.AppException;
//import com.system.powerup.repo.LoginRepo;
//import com.system.powerup.services.LoginService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class LoginServiceImpl implements LoginService {
//    private final LoginRepo loginRepo;
//    @Override
//    public Login findByEmail(String email) {
//        Login login= loginRepo.findByEmail(email)
//                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
//
//        //builder
//
//        return login;
//    }
//}
