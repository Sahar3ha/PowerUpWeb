package com.system.powerup.services.impl;

import com.system.powerup.Entity.SignUp;

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
    @Override
    public String saveUser(SignUpPojo signUpPojo) {
        SignUp sign = new SignUp();
        sign.setEmail(signUpPojo.getEmail());
        sign.setFullName(signUpPojo.getFullName());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(signUpPojo.getPassword());
        sign.setPassword(encodedPassword);

        signUpRepo.save(sign);
        return "creates";


//    @Override
//    public SignUp findByEmail(String email) {
//        SignUp sign =signUpRepo.findByEmail(email)
//                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
//
//        //builder
//
//        return sign;
//    }

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

//    @Override
//    public SignUp fetchByEmail(String email) {
//        SignUp signup= signUpRepo.findById(email).orElseThrow(()-> new RuntimeException("Couldnot find"));
//        signup = SignUp.builder()
//                .productId(product.getProductId())
//                .imageBase64(getImageBase64(product.getImage()))
//                .productTitle(product.getProductTitle())
//                .productCategory(product.getProductCategory())
//                .productDescription(product.getProductDescription())
//                .productPrice(product.getProductPrice())
//                .brandName(product.getBrandName())
//                .size(product.getSize())
//                .build();
//        return product;
//    }

//    @Override
//    public List<SignUp> fetchAll() {
//        return null;
//    }
}
