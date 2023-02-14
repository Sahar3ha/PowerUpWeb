package com.system.powerup.controller;

import com.system.powerup.Entity.User;
import com.system.powerup.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class Ucontroller {
    private UserService userService;
    @GetMapping("/uList")
    public String getPage(Model model, Principal principal){
        String email=principal.getName();
        User user = userService.findByEmail(email);

//        model.addAttribute("userList", users.stream().map(user ->
//                User.builder()
//                        .id(user.getId())
//                        .signup_id(user.getSignup_id())
//                        .membership_id(user.getMembership_id())
//                        .build()
//
//        ));

        model.addAttribute("userList",user);
        return "User/user_list";
    }

}
