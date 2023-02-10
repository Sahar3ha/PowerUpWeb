//package com.system.powerup.controller;
//
//
//import com.system.powerup.Entity.Category;
//import com.system.powerup.pojo.CategoryPojo;
//import com.system.powerup.services.CategoryService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.Base64;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/user")
//public class CategoryController {
//
//    private final CategoryService categoryService;
//
//    @GetMapping("/category")
//    public String addCategory(Model model){
//        model.addAttribute("category",new CategoryPojo());
//        return "User/Admin-category";
//    }
//    @GetMapping("/new")
//    public String newee(){
//        return "User/Admin_profile";
//    }
//
//
//    public String getImageBase64(String filename){
//        String filePath = System.getProperty("user.dir")+"/powerupImages/";
//        File file = new File(filePath + filename);
//        byte[] bytes;
//
//        try {
//            bytes = Files.readAllBytes(file.toPath());
//        }catch (IOException e){
//            e.printStackTrace();
//            return null;
//        }
//        return Base64.getEncoder().encodeToString(bytes);
//    }
//
//    @PostMapping("/image")
//    public String saveCategory(@Valid CategoryPojo categoryPojo, BindingResult bindingResult,
//                               RedirectAttributes redirectAttributes) throws IOException{
//
//        Map<String, String> requestError = validateRequest(bindingResult);
//        if(requestError!=null){
//            redirectAttributes.addFlashAttribute("requestError",requestError);
//            return "redirect:/user/category";
//        }
//
//        categoryService.addCategory(categoryPojo);
//        redirectAttributes.addFlashAttribute("successMsg","Saved Successfully");
//        return "redirect:/user/new";
//
//    }
//
//
//    private Map<String, String> validateRequest(BindingResult bindingResult) {
//        if (!bindingResult.hasErrors()){
//            return null;
//        }
//        Map<String,String>errors = new HashMap<>();
//        bindingResult.getAllErrors().forEach(error->{
//            String fieldName=((FieldError) error).getField();
//            String message = error.getDefaultMessage();
//            errors.put(fieldName, message);
//        });
//        return errors;
//    }
//
//
//    public String categoryList(Model model){
//        List<Category>categories = categoryService.fetchAll();
//        model.addAttribute("category",categories.stream().map(category ->
//            Category.builder()
//                    .catrgoryId(category.getCatrgoryId())
//                    .imageBase64(getImageBase64((category.getImage())))
//                    .categoryName(category.getCategoryName())
//                    .categoryDescription(category.getCategoryDescription())
//                    .build()
//
//        ));
//            return "list";
//
//    }
//
//
//
//}
