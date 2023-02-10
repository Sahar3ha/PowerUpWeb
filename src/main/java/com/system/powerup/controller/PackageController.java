//package com.system.powerup.controller;
//
//import com.system.powerup.pojo.MembershipPojo;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping()
//public class PackageController {
//    @GetMapping("/weightlifting")
//    public String getWeightlifting(Model model){
//        model.addAttribute("member", new MembershipPojo());
//        return "User/weightlifting";
//    }
//
//    @GetMapping("/boxing")
//    public String getBoxing(Model model){
//        model.addAttribute("member", new MembershipPojo());
//        return "User/boxing";
//    }
//
//    @GetMapping("/calisthenics")
//    public String getCalisthenics(Model model){
//        model.addAttribute("member", new MembershipPojo());
//        return "User/calisthenics";
//    }
//}
