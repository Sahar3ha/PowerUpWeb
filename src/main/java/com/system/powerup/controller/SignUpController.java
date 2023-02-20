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

import org.springframework.data.crossstore.ChangeSetPersister;
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
        model.addAttribute("mem",new MembershipPojo());
        model.addAttribute("signup", new SignUpPojo());
        return "User/signup";
    }
    @PostMapping("/save" )
    public String saveUser(@Valid SignUpPojo signUpPojo )throws IOException {
        signUpService.saveUser(signUpPojo);
        Membership membership = new Membership();

        membershipRepo.save(membership);

        return "redirect:/login";
    }

    @PostMapping("/update")
    public String updateUser(@Valid SignUpPojo signUpPojo)throws IOException {
        signUpService.updateUser(signUpPojo);
        return "redirect:/homepage";
    }
    @PostMapping("/updateMember")
    public String updateMember(@Valid MembershipPojo membershipPojo )throws IOException {
        membershipService.saveMember(membershipPojo);
        return "redirect:/homepage";
    }



    @GetMapping("/list/{id}")
    public String getUserDetails(@PathVariable("id") Integer id,Model model) throws ChangeSetPersister.NotFoundException {
        SignUp signUp =signUpService.fetchById(id);
        Membership membership =membershipService.fetchById(id);


        model.addAttribute("memberUpdate",new MembershipPojo());
        model.addAttribute("update", new SignUpPojo(signUp));

        model.addAttribute("userList",signUpService.fetchById(id));
        model.addAttribute("members", membershipService.fetchById(id));

        model.addAttribute("tab1Active", true);
        model.addAttribute("tab2Active", false);


        return "User/profile";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable ("id") Integer id){
        signUpService.deleteById(id);
        membershipService.deleteAllBy(id);
        return "redirect:/signup";
    }



}
