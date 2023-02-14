package com.system.powerup.controller;

import com.system.powerup.Entity.Membership;
import com.system.powerup.Entity.SignUp;
import com.system.powerup.pojo.MembershipPojo;
import com.system.powerup.pojo.SignUpPojo;
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

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class MembershipController {
    private final MembershipService membershipService;
    private final SignUpService signUpService;
//    static List<String> categoryList= null;
//
//    static {
//        categoryList = new ArrayList<>();
//        categoryList.add("weightlifting");
//        categoryList.add("boxing");
//        categoryList.add("calisthenics");
//    }
//    @GetMapping("/category")
//    public String load(Model model){
//        model.addAttribute("categoryList",new MembershipPojo());
//        return "User/weightlifting";
//    }

//    @PostMapping("/category")
//    public String category(Model model){
//        model.addAttribute("categories",categoryList);
//        return "User/weightlifting";
//    }



//    @PostMapping("/category")
//    public String membershipSubmission(@Valid MembershipPojo membershipPojo) {
//        membershipService.saveMember(membershipPojo);
//        return "redirect:/category/new";
//    }
//    @GetMapping("/new")
//    public  String getHome(){
//        return "User/gg";
//    }

    @GetMapping("/weightlifting/{id}")
    public  String getWeightlifting(@PathVariable("id") Integer id, Model model){


        model.addAttribute("userdata",signUpService.fetchById(id));

//        SignUp user = signUpService.fetchById(id);
//        model.addAttribute("signup", new SignUpPojo(user));
//        model.addAttribute("signups", user);
        model.addAttribute("member", new MembershipPojo());
        return "User/weightlifting";
    }
    @GetMapping("/boxing/{id}")
    public  String getBoxing(@PathVariable("id") Integer id, Model model){


        model.addAttribute("userdata",signUpService.fetchById(id));

//        SignUp user = signUpService.fetchById(id);
//        model.addAttribute("signup", new SignUpPojo(user));
//        model.addAttribute("signups", user);
        model.addAttribute("member", new MembershipPojo());
        return "User/boxing";
    }
    @GetMapping("/calisthenics/{id}")
    public  String getCalisthenics(@PathVariable("id") Integer id, Model model){


        model.addAttribute("userdata",signUpService.fetchById(id));

//        SignUp user = signUpService.fetchById(id);
//        model.addAttribute("signup", new SignUpPojo(user));
//        model.addAttribute("signups", user);
        model.addAttribute("member", new MembershipPojo());
        return "User/calisthenics";
    }


//    @PostMapping("/updateprofile")
//    public String updateRegister(@Valid SignUpPojo userPojo){
//        signUpService.saveUser(userPojo);
//
//        return "redirect:/user/index";}

//    @GetMapping("/weightlifting/{id}")
//    public String getWeightlifting(@PathVariable("id") Integer id, Model model, Principal principal){
//        SignUp signUp = signUpService.fetchById(id);
//        model.addAttribute("uId",new SignUpPojo(signUp));
//        model.addAttribute("member", new MembershipPojo());
//        return "User/weightlifting";
//    }

    @GetMapping("/boxing")
    public String getBoxing(Model model){
        model.addAttribute("member", new MembershipPojo());
        return "User/boxing";
    }

    @GetMapping("/calisthenics")
    public String getCalisthenics(Model model){
        model.addAttribute("member", new MembershipPojo());
        return "User/calisthenics";
    }



    @PostMapping("/saveMembership")
    public String saveUser(@Valid MembershipPojo membershipPojo)throws IOException {
        membershipService.saveMember(membershipPojo);
        return "redirect:/homepage";
    }
}
