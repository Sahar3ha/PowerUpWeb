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

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class MembershipController {
    private final MembershipService membershipService;
    private final AdminService adminService;
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

    @GetMapping("/membership")
    public  String getWeightlifting(Model model,Principal principal){

        model.addAttribute("tab1Active", true);
        model.addAttribute("tab2Active", false);
        model.addAttribute("tab3Active", false);
        String email = principal.getName();
        SignUp user = signUpService.fetchByEmail(email);

        model.addAttribute("userdata",signUpService.fetchById(user.getId()));

        List<Admin> admins = adminService.fetchAll();


        model.addAttribute("priceTable", admins.stream().map(admin ->
                Admin.builder()
                        .id(admin.getId())
                        .duration(admin.getDuration())
                        .price(admin.getPrice())
                        .build()

        ));
        model.addAttribute("member", new MembershipPojo());
        return "User/weightlifting";
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
