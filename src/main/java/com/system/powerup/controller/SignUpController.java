package com.system.powerup.controller;

import com.system.powerup.Entity.Admin;
import com.system.powerup.Entity.Category;
import com.system.powerup.Entity.Membership;
import com.system.powerup.Entity.SignUp;
import com.system.powerup.dto.SignUpDto;
import com.system.powerup.pojo.MembershipPojo;
import com.system.powerup.pojo.SignUpPojo;
import com.system.powerup.repo.MembershipRepo;
import com.system.powerup.services.AdminService;
import com.system.powerup.services.CategoryService;
import com.system.powerup.services.MembershipService;
import com.system.powerup.services.SignUpService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
@Tag(name = "UserController" , description = "all user related api")
public class SignUpController {

    private final SignUpService signUpService;
    private final MembershipService membershipService;
    private final CategoryService categoryService;
    private final AdminService adminService;
    private final MembershipRepo membershipRepo;

    @Operation(summary = "Creates a new User",description = "Registers a new user")
    @GetMapping("/signup")
    public String createUser(Model model){

        model.addAttribute("signup", new SignUpPojo());
        return "User/signup";
    }
//    @Operation(summary = "Saves the user details",description = "saves user data and navigates to login page")
//    @PostMapping("/save" )
//    public String saveUser(@Valid SignUpPojo signUpPojo)throws IOException {
//
//        signUpService.saveUser(signUpPojo);
//
/// /        membershipService.saveMember(membershipPojo);
//        return "redirect:/login";
//    }

@Operation(summary = "Saves the user details",description = "saves user data and navigates to login page")
@PostMapping("/save" )
public ResponseEntity<SignUpDto> saveUser(@Valid @RequestBody SignUpPojo signUpPojo) throws IOException {

    SignUpDto savedUser = signUpService.saveUser(signUpPojo);

    return ResponseEntity.ok(savedUser);
}

    @Operation(summary = "Updates user details", description = "Returns updated user details")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@Valid SignUpPojo signUpPojo)throws IOException {
        SignUpDto sign =  signUpService.updateUser(signUpPojo);
        return ResponseEntity.ok(sign);
    }

    @Operation(summary = "Updates membership details",description = "Updates membership details and navigates to homepage")
    @PostMapping("/updateMember")
    public String updateMember(@Valid MembershipPojo membershipPojo )throws IOException {
        membershipService.saveMember(membershipPojo);
        return "redirect:/homepage";
    }


    @Operation(summary = "Fetches user details",description = "Returns user and membership details")
    @GetMapping("/list/{id}")
    public String getUserDetails(@PathVariable("id") Integer id,Model model){
        SignUp signUp =signUpService.fetchById(id);
        Membership membership =membershipService.fetchById(id);
        List<Category> categories= Collections.singletonList(categoryService.fetchById(id));
        List<Admin>admins=adminService.fetchAll();

        model.addAttribute("categories",categories);
        model.addAttribute("duration",admins);


        model.addAttribute("memberUpdate",new MembershipPojo());
        model.addAttribute("update", new SignUpPojo(signUp));

        model.addAttribute("userList",signUp);
        model.addAttribute("members", membership);

        model.addAttribute("tab1Active", true);
        model.addAttribute("tab2Active", false);


        return "User/profile";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable ("id") Integer id) throws IOException {
//        MembershipPojo membershipPojo=new MembershipPojo();
//        membershipPojo.setUser_id(null);
//        membershipPojo.setPrice_id(null);
//        membershipPojo.setCategory_id(null);
        membershipService.deleteById(id);
        return "redirect:/homepage";
    }

    @Operation(summary = "Deletes user details",description = "Deletes User account")
    @GetMapping("/deleteAccount/{id}")
    public String deleteAcc(@PathVariable ("id") Integer id) throws IOException {
//        MembershipPojo membershipPojo=new MembershipPojo();
//        membershipPojo.setUser_id(null);
//        membershipPojo.setPrice_id(null);
//        membershipPojo.setCategory_id(null);
        signUpService.deleteById(id);
        membershipService.deleteById(id);
        return "redirect:/homepage";
    }



}
