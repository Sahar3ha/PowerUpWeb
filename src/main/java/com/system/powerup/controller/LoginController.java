package com.system.powerup.controller;

import com.system.powerup.Entity.SignUp;
import com.system.powerup.pojo.SignUpPojo;
import com.system.powerup.services.SignUpService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class LoginController {
    private final SignUpService signUpService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            model.addAttribute("signup", new SignUpPojo());
            return "User/Login";
        }
        return "redirect:/homepage";
    }

    @GetMapping("/home")
    public String logout(Authentication authentication){
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.clearContext();
        }
        return "User/gg";
    }

    @GetMapping("/homepage")
    public  String getHome(Model model, Principal principal){
        String email = principal.getName();
        SignUp user = signUpService.fetchByEmail(email);
        model.addAttribute("user",user);
        return "User/gg";
    }

    @GetMapping("/nav")
    public String nav(Model model,Principal principal){
        String email = principal.getName();
        SignUp user = signUpService.fetchByEmail(email);
        model.addAttribute("nav",user);
        return "User/profile";


    }



}