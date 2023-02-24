package com.system.powerup.controller;

import com.system.powerup.Entity.Admin;
import com.system.powerup.Entity.Category;
import com.system.powerup.Entity.Membership;
import com.system.powerup.Entity.SignUp;
import com.system.powerup.pojo.AdminPojo;
import com.system.powerup.pojo.MembershipPojo;
import com.system.powerup.pojo.SignUpPojo;
import com.system.powerup.repo.MembershipRepo;
import com.system.powerup.services.AdminService;
import com.system.powerup.services.CategoryService;
import com.system.powerup.services.MembershipService;
import com.system.powerup.services.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    private final CategoryService categoryService;
    private final AdminService adminService;
    private final SignUpService signUpService;
    private final MembershipRepo membershipRepo;



    @GetMapping("/membership/{id}")
    public  String getWeightlifting(@PathVariable("id") Integer id, Model model){

        model.addAttribute("tab1Active", true);
        model.addAttribute("tab2Active", false);
        model.addAttribute("tab3Active", false);
        SignUp signUp = signUpService.fetchById(id);


        model.addAttribute("userdata",signUpService.fetchById(id));
//        model.addAttribute("up",membershipService.fetchById(id));

        List<Admin> admins = adminService.fetchAll();
        List<Category> categories = categoryService.fetchAll();
        model.addAttribute("priceTable", admins);
        model.addAttribute("categories",categories);

        model.addAttribute("member", new MembershipPojo());
        return "User/weightlifting";
    }

    @PostMapping("/saveMembership")
    public String saveUser(@Valid MembershipPojo membershipPojo)throws IOException {
        membershipService.saveMember(membershipPojo);
        return "redirect:/homepage";
    }
    @GetMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        membershipRepo.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Row delete successfully");
        return "redirect:/homepage";
    }

}
