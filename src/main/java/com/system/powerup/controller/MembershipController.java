package com.system.powerup.controller;

import com.system.powerup.Entity.Membership;
import com.system.powerup.pojo.MembershipPojo;
import com.system.powerup.services.MembershipService;
import com.system.powerup.services.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class MembershipController {
    private final MembershipService membershipService;
    static List<String> categoryList= null;

    static {
        categoryList = new ArrayList<>();
        categoryList.add("weightlifting");
        categoryList.add("boxing");
        categoryList.add("calisthenics");
    }
    @GetMapping("/category")
    public String load(Model model){
        model.addAttribute("categoryList",new MembershipPojo());
        return "User/weightlifting";
    }

//    @PostMapping("/category")
//    public String category(Model model){
//        model.addAttribute("categories",categoryList);
//        return "User/weightlifting";
//    }



    @PostMapping("/category")
    public String membershipSubmission(@Valid MembershipPojo membershipPojo) {
        membershipService.saveMember(membershipPojo);
        return "redirect:/category/new";
    }
    @GetMapping("/new")
    public  String getHome(){
        return "User/gg";
    }
}
