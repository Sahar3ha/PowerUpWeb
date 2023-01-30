//package com.system.powerup.controller;
//
//import com.system.powerup.Entity.User;
//import com.system.powerup.pojo.UserPojo;
//import com.system.powerup.services.UserService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.Base64;
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/user")
//public class UserController {
//
//    private final UserService userService;
//
//    @GetMapping("/list")
//    public String getUserList(Model model){
//        List<User> users = userService.fetchAll();
//        model.addAttribute("userList", users);
//
//        return "User/index";
//    }
//
//    @GetMapping("/user/create")
//    public String getPage(){
//        return "User/create";
//    }
//
//    @GetMapping("/create")
//    public String createUser(Model model){
//        model.addAttribute("user", new UserPojo());
//        return ("User/create");
//    }
//
//    @GetMapping("/edit/{id}")
//    public String editUser(@PathVariable("id") Integer id, Model model){
//        User user = userService.fetchById(id);
//        model.addAttribute("user", new UserPojo(user));
//        return "User/create";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable ("id") Integer id){
//        userService.deleteById(id);
//        return "redirect:/user/list";
//    }
//    @GetMapping("/sendEmail")
//    public String senRegistrationEmail(){
//        this.userService.sendEmail();
//        return "emailSuccess";
//    }
//
////    @PostMapping("/save")
////    public String saveUser(@Valid UserPojo userPojo) throws IOException {
////        userService.save(userPojo);
////        return "redirect:/user/list"; //router ko path
////    }
//
////    public String getImageBase64(String fileName) {
////        String filePath = System.getProperty("user.dir") + "/canteen_mgmt/";
////        File file = new File(filePath + fileName);
////        byte[] bytes = new byte[0];
////        try {
////            bytes = Files.readAllBytes(file.toPath());
////        } catch (IOException e) {
////            e.printStackTrace();
////            return null;
////        }
////        String base64 = Base64.getEncoder().encodeToString(bytes);
////        return base64;
////    }
////    @GetMapping("/list")
////    public String getUSerList(Model model) {
////        List<User> users = userService.fetchAll();
////
////
////        model.addAttribute("userList", users.stream().map(user ->
////                User.builder()
////                        .id(user.getId())
////                        .imageBase64(getImageBase64(user.getImage()))
////                        .email(user.getEmail())
////                        .fullName(user.getFullName())
////                        .mobileNo(user.getMobileNo())
////                        .build()
////
////        ));
////
//////        model.addAttribute("UPLOAD_DIRECTORY", "/" + UPLOAD_DIRECTORY);
////
////        return "user_list";
////    }
//}
