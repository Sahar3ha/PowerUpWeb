//package com.system.powerup.services.impl;
//
//import com.system.powerup.Entity.SignUp;
//import com.system.powerup.Entity.User;
//import com.system.powerup.exception.AppException;
//import com.system.powerup.pojo.UserPojo;
//
//import com.system.powerup.repo.UserRepo;
//import com.system.powerup.services.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//    private final UserRepo userRepo;
////    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/canteen_mgmt";
//
//
//
//    @Override
//    public String save(UserPojo userPojo) {
//        User user = new User();
//        if(userPojo.getId()!=null){
//            user.setId(userPojo.getId());
//        }
//        user.setEmail(userPojo.getEmail());
//        user.setFullName(userPojo.getFullName());
//        user.setMobileNo(userPojo.getMobile_no());
//        user.setPassword(userPojo.getPassword());
////        if(userPojo.getImage()!=null){
////            StringBuilder fileNames = new StringBuilder();
////            System.out.println(UPLOAD_DIRECTORY);
////            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, userPojo.getImage().getOriginalFilename());
////            fileNames.append(userPojo.getImage().getOriginalFilename());
////            Files.write(fileNameAndPath, userPojo.getImage().getBytes());
////
////            user.setImage(userPojo.getImage().getOriginalFilename());
////        }
//        userRepo.save(user);
//        return "created";
//    }
//
//    @Override
//    public List<User> fetchAll() {
//        return  userRepo.findAll();
//
//    }
//
//    @Override
//    public User fetchById(Integer id) {
//        return userRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        userRepo.deleteById(id);
//    }
//
//    @Override
//    public void sendEmail() {
//        User user = userRepo;
//    }
//
//    @Override
//    public User findByEmail(String email) {
//        User user = userRepo.findByEmail(email)
//                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
//
//        //builder
//
//        return user;
//    }
//
//}
//
