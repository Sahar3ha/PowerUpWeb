package com.system.powerup.controller;

import com.system.powerup.Entity.Admin;
import com.system.powerup.Entity.Membership;
import com.system.powerup.Entity.SignUp;
import com.system.powerup.pojo.AdminPojo;
import com.system.powerup.pojo.MembershipPojo;
import com.system.powerup.pojo.SignUpPojo;
import com.system.powerup.services.AdminService;
import com.system.powerup.services.MembershipService;
import com.system.powerup.services.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class MembershipController {
    private final MembershipService membershipService;
    private final AdminService adminService;
    private final SignUpService signUpService;



    @GetMapping("/membership")
    public  String getWeightlifting(Model model,Principal principal){

        model.addAttribute("tab1Active", true);
        model.addAttribute("tab2Active", false);
        model.addAttribute("tab3Active", false);
        String email = principal.getName();
        SignUp user = signUpService.fetchByEmail(email);
        model.addAttribute("userdata",signUpService.fetchById(user.getId()));

        List<Admin> admins = adminService.fetchAll();

        model.addAttribute("priceTable", admins);
        List<String> categories = Arrays.asList("Weightlifting", "Boxing", "Calisthenics");
        model.addAttribute("categories",categories);
        model.addAttribute("member", new MembershipPojo());
        return "User/weightlifting";
    }

    @PostMapping("/saveMembership")
    public String saveUser(@Valid MembershipPojo membershipPojo)throws IOException {

        membershipService.saveMember(membershipPojo);
        return "redirect:/homepage";
    }
}
