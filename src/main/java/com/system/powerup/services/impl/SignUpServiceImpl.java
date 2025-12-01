package com.system.powerup.services.impl;

import com.system.powerup.Entity.SignUp;

import com.system.powerup.dto.SignUpDto;
import com.system.powerup.exception.AppException;
import com.system.powerup.pojo.SignUpPojo;
import com.system.powerup.repo.SignUpRepo;
import com.system.powerup.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private final SignUpRepo signUpRepo;
//    @Override
//    public SignUpPojo saveUser(SignUpPojo signUpPojo) throws IOException {
//        SignUp signUp;
//        if (signUpPojo.getId() != null) {
//            signUp = signUpRepo.findById(signUpPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
//        } else {
//            signUp = new SignUp();
//        }
//        signUp.setEmail(signUpPojo.getEmail());
//        signUp.setFullName(signUpPojo.getFullName());
//        signUp.setPassword(PasswordEncoderUtil.getInstance().encode(signUpPojo.getPassword()));
//
//        signUpRepo.save(signUp);
//        return new SignUpPojo(signUp);
//
//
//    }
public SignUpDto toDto(SignUp entity) {
    SignUpDto dto = new SignUpDto();
    dto.setFullName(entity.getFullName());
    dto.setEmail(entity.getEmail());
    return dto;
}

    @Override
public SignUpDto saveUser(SignUpPojo pojo) throws IOException {
    SignUp signUp = new SignUp();

    signUp.setEmail(pojo.getEmail());
    signUp.setFullName(pojo.getFullName());
    signUp.setPassword(pojo.getPassword());
    SignUpDto response = new SignUpDto();

    SignUp savedUser = signUpRepo.save(signUp);

    return toDto(savedUser);


}
//    @Override
//    public SignUpPojo updateUser(SignUpPojo signUpPojo) throws IOException {
//        SignUp signUp;
//
//        if (signUpPojo.getId() != null) {
//            signUp = signUpRepo.findById(signUpPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
//        } else {
//            signUp = new SignUp();
//        }
////        Controller Advice
////        Status Code
//        signUp.setEmail(signUpPojo.getEmail());
//        signUp.setFullName(signUpPojo.getFullName());
//
//        signUpRepo.save(signUp);
//        return new SignUpPojo(signUp);
//
//    }

    @Override
    public SignUpDto updateUser(SignUpPojo signUpPojo) throws IOException {
        SignUp signUp;

        if (signUpPojo.getId() != null) {
            signUp = signUpRepo.findById(signUpPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            signUp = new SignUp();
        }
//        Controller Advice
//        Status Code
        signUp.setEmail(signUpPojo.getEmail());
        signUp.setFullName(signUpPojo.getFullName());

        signUpRepo.save(signUp);
        return new SignUpDto(signUp);

    }



    @Override
    public SignUp fetchByEmail(String email) {
        SignUp signUp = signUpRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));

        //builder

        return signUp;
    }

    @Override
    public SignUp fetchById(Integer id) {
        return signUpRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }

    @Override
    public void deleteById(Integer id) {
        signUpRepo.deleteById(id);
    }



    @Override
    public List<SignUp> fetchAll() {
        return signUpRepo.findAll();
    }
}
