package com.system.powerup.controller;

import com.system.powerup.Entity.Membership;
import com.system.powerup.Entity.SignUp;
import com.system.powerup.pojo.MembershipPojo;
import com.system.powerup.pojo.SignUpPojo;
import com.system.powerup.repo.MembershipRepo;
import com.system.powerup.repo.SignUpRepo;
import com.system.powerup.services.MembershipService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")

public class SignUpController {

    private final SignUpService signUpService;
    private final MembershipService membershipService;
    private final MembershipRepo membershipRepo;

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

    @PostMapping("/update")
    public String updateUser(@Valid SignUpPojo signUpPojo)throws IOException {
        signUpService.updateUser(signUpPojo);
        return "redirect:/homepage";
    }
//    @PostMapping("/update")
//    public String updateMember(@Valid MembershipPojo membershipPojo )throws IOException {
//        membershipService.saveMember(membershipPojo);
//        return "redirect:/homepage";
//    }
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
    @GetMapping("/list/{id}")
    public String getUserDetails(@PathVariable("id") Integer id,Model model,Principal principal,MembershipPojo membershipPojo) {
//        String email = principal.getName();
//        SignUp user = signUpService.fetchByEmail(email);
//        String email =principal.getName();
        SignUp signUp =signUpService.fetchById(id);
        Membership membership =membershipService.fetchById(id);

        model.addAttribute("member",new MembershipPojo(membership));
        model.addAttribute("update",new SignUpPojo(signUp));

        model.addAttribute("userList",signUpService.fetchById(id));
        model.addAttribute("member", membershipService.fetchById(id));

        model.addAttribute("tab1Active", true);
        model.addAttribute("tab2Active", false);


        return "User/profile";
    }

    @PostMapping ("/edit")
    public String editUser(SignUpPojo signUpPojo) throws IOException {

        signUpService.saveUser(signUpPojo);


        return "redirect:/weightlifting";
    }
    @GetMapping("/{id}")
    public String deleteUser(@PathVariable ("id") Integer id,Principal principal){
        SignUp signUp =signUpService.fetchByEmail(principal.getName());
//        membershipService.deleteById(id);
        signUpService.deleteById(id);
        membershipService.deleteById(id);
        return "redirect:/signup";
    }

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
