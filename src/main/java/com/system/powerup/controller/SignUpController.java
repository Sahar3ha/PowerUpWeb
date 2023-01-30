package com.system.powerup.controller;

import com.system.powerup.Entity.SignUp;
import com.system.powerup.pojo.SignUpPojo;
import com.system.powerup.services.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping("/login")
    public String getPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            model.addAttribute("signup", new SignUpPojo());
            return "User/Login";
        }
        return "redirect:/signup/homepage";
    }

    @PostMapping("/save")
    public String saveUser(@Valid SignUpPojo signUpPojo){
        signUpService.saveUser(signUpPojo);
        return "redirect:/signup/login";
    }

    @GetMapping("/homepage")
        public  String getHome(){
            return "User/gg";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model){
        SignUp signUp = signUpService.fetchById(id);
        model.addAttribute("signup", new SignUpPojo(signUp));
        return "User/signup";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable ("id") Integer id){
        signUpService.deleteById(id);
        return "redirect:/user/list";
    }


}
