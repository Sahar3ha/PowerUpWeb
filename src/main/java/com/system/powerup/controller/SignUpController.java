package com.system.powerup.controller;

import com.system.powerup.Entity.SignUp;
import com.system.powerup.pojo.SignUpPojo;
import com.system.powerup.repo.SignUpRepo;
import com.system.powerup.services.SignUpService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")

public class SignUpController {

    private final SignUpService signUpService;
    @GetMapping("/signup")
    public String createUser(Model model){
        model.addAttribute("signup", new SignUpPojo());
        return "User/signup";
    }
    @PostMapping("/save")
    public String saveUser(@Valid SignUpPojo signUpPojo )throws IOException {
        signUpService.saveUser(signUpPojo);
        return "redirect:/login";
    }
//    @GetMapping("/list")
//    public String getUserList(Model model){
//        List<SignUp> sign = signUpService.fetchAll();
//        model.addAttribute("userList", sign);
//
//        return "User/profile";
//    }
//@GetMapping("/list")
//public String getUSerList(Model model) {
//    List<SignUp> users = signUpService.fetchAll();
//
//
//    model.addAttribute("userList", users.stream().map(user ->
//            SignUp.builder()
//                    .id(user.getId())
//                    .email(user.getEmail())
//                    .fullName(user.getFullName())
//                    .build()
//
//    ));
//
////        model.addAttribute("UPLOAD_DIRECTORY", "/" + UPLOAD_DIRECTORY);
//
//    return "User/user_list";
//}

    //for single
//    @GetMapping("/list")
//    public String getUserList(Model model, Principal principal) {
//        String email = principal.getName();
//        SignUp user = signUpService.fetchByEmail(email);
//
//        model.addAttribute("userList", user);
//
//        return "User/user_list";
//    }
    @GetMapping("/list")
    public String getUserDetails(Principal principal,Model model) {
        String email = principal.getName();
        SignUp user = signUpService.fetchByEmail(email);
        model.addAttribute("userList", user);
        return "User/profile";
    }

    @PostMapping ("/edit")
    public String editUser(SignUpPojo signUpPojo) throws IOException {
        signUpService.saveUser(signUpPojo);

        return "redirect:/weightlifting";
    }
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable ("id") Integer id){
//        signUpService.deleteById(id);
//        return "redirect:/user/list";
//    }

//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
//        SignUp signUp = signUpService.fetchById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        model.addAttribute("user", signUp);
//        return "User/weightlifting";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateUser(@PathVariable("id") long id, @ModelAttribute SignUp signUp, Model model) {
//        signUpRepo.save(signUp);
//        model.addAttribute("users", signUpRepo.findAll());
//        return "User/gg";
//    }


}
