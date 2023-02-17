package com.system.powerup.controller;

import com.system.powerup.Entity.Admin;
import com.system.powerup.Entity.Membership;
import com.system.powerup.pojo.AdminPojo;
import com.system.powerup.pojo.SignUpPojo;
import com.system.powerup.services.AdminService;
import com.system.powerup.services.MembershipService;
import com.system.powerup.services.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final MembershipService membershipService;
    @GetMapping("/list")
    public String getUSerList(Model model) {

        List<Membership> memberships = membershipService.fetchAll();


        model.addAttribute("members", memberships.stream().map(membership ->
                Membership.builder()
                        .id(membership.getId())
                        .category(membership.getCategory())
                        .duration(membership.getDuration())
                        .user_id(membership.getUser_id())
                        .build()

        ));
        return "User/user_list";
    }

    @GetMapping("/price")
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
    @PostMapping("/savePrice")
    public String addPrice(@Valid AdminPojo adminPojo )throws IOException {
        adminService.save(adminPojo);
        return "redirect:/admin/price";
    }

    @GetMapping("/create")
    public String editPrice(Model model) {
        model.addAttribute("price",new AdminPojo());
        return "User/create";
    }
    @GetMapping("/edit/{id}")
    public String getPrice(@PathVariable("id") Integer id,Model model){
//        Admin admin = adminService.fetchById(id);
        model.addAttribute("price",adminService.fetchById(id));
        return "redirect:/admin/create";
    }


    @GetMapping("/{id}")
    public String deletePrice(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        adminService.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Row delete successfully");
        return "redirect:/admin/price";
    }
}
