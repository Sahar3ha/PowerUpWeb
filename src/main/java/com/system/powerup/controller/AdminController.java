package com.system.powerup.controller;

import com.system.powerup.Entity.Admin;
import com.system.powerup.Entity.Category;
import com.system.powerup.Entity.Membership;
import com.system.powerup.Entity.SignUp;
import com.system.powerup.pojo.AdminPojo;
import com.system.powerup.pojo.MembershipPojo;
import com.system.powerup.pojo.SignUpPojo;
import com.system.powerup.services.AdminService;
import com.system.powerup.services.CategoryService;
import com.system.powerup.services.MembershipService;
import com.system.powerup.services.SignUpService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final CategoryService categoryService;
    private final SignUpService signUpService;

    private final AdminService adminService;
    private final MembershipService membershipService;
    @GetMapping("/list")
    @Operation(summary = "Gets user list",description = "Fetches the registered users from database")
    public String getUSerList(Model model) {

        List<Membership> memberships = membershipService.fetchAll();

        model.addAttribute("members", memberships.stream().map(membership -> {
            Category category = categoryService.fetchById(membership.getCategory_id().getId());
            Admin admin = adminService.fetchById(membership.getPrice_id().getId());
            SignUp user = signUpService.fetchById(membership.getUser_id().getId());

            return Membership.builder()
                    .id(membership.getId())
                    .category_id(membership.getCategory_id())
                    .price_id(membership.getPrice_id())
                    .user_id(membership.getUser_id())
                    .category_id(category)
                    .price_id(admin)
                    .user_id(user)
                    .build();
        }).collect(Collectors.toList()));

        return "User/user_list";
    }

    @GetMapping("/price")
    @Operation(summary = "Gets price ")
    public String getPricePage(Model model){
//        model.addAttribute("priceTab",new Admin());
        List<Admin> admins = adminService.fetchAll();


        model.addAttribute("priceTable", admins.stream().map(admin ->
                Admin.builder()
                        .id(admin.getId())
                        .duration(admin.getDuration())
                        .price(admin.getPrice())
                        .build()

        ));
        return "User/price";
    }
    @Operation(summary = "Admin sets price for the package",description = "Saves price for a package")
    @PostMapping("/savePrice")
    public ResponseEntity<?> addPrice(@Valid AdminPojo adminPojo )throws IOException {
        AdminPojo adminPojo1 = adminService.save(adminPojo);
        return ResponseEntity.ok(adminPojo1);
    }

    @GetMapping("/create")
    public String editPrice(Model model) {

        model.addAttribute("price",new AdminPojo());
        return "User/create";
    }
    @GetMapping("/edit/{id}")
    public String getPrice(@PathVariable("id") Integer id,Model model){
        Admin admin = adminService.fetchById(id);
        model.addAttribute("price",admin);
        return "User/create";
    }


    @GetMapping("/{id}")
    @Operation(summary = "Deletes prices for package",description = "Admin panel delete button")
    public String deletePrice(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        Membership membership=new Membership();
        membership.setPrice_id(null);
//        membershipService.deleteById(id);
        adminService.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Row delete successfully");
        return "redirect:/admin/price";
    }
}
