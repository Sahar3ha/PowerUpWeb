package com.system.powerup.services.impl;

import com.system.powerup.Entity.SignUp;

import com.system.powerup.config.PasswordEncoderUtil;
import com.system.powerup.dto.SignUpDto;
import com.system.powerup.exception.AppException;
import com.system.powerup.pojo.SignUpPojo;
import com.system.powerup.repo.SignUpRepo;
import com.system.powerup.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

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
@Override
public SignUpDto saveUser(SignUpDto signUpDto) throws IOException {
    SignUp signUp = new SignUp();
    if (signUpDto.getId() != null) {
            signUp = signUpRepo.findById(signUpDto.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            signUp = new SignUp();
        }
    signUp.setEmail(signUpDto.getEmail());
    signUp.setFullName(signUpDto.getFullName());
    signUp.setPassword(signUpDto.getPassword());

    return signUpRepo.save(signUp);


}
    @Override
    public SignUpPojo updateUser(SignUpPojo signUpPojo) throws IOException {
        SignUp signUp;

        if (signUpPojo.getId() != null) {
            signUp = signUpRepo.findById(signUpPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            signUp = new SignUp();
        }
        signUp.setEmail(signUpPojo.getEmail());
        signUp.setFullName(signUpPojo.getFullName());

        signUpRepo.save(signUp);
        return new SignUpPojo(signUp);

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
