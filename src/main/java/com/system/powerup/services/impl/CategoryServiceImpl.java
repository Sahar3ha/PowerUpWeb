package com.system.powerup.services.impl;

import com.system.powerup.Entity.Category;
import com.system.powerup.pojo.CategoryPojo;
import com.system.powerup.repo.CategoryRepo;
import com.system.powerup.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    public static String UploadDirectory = System.getProperty("user.dir")+"/powerupImages";


    @Override
    public CategoryPojo addCategory(CategoryPojo categoryPojo) throws IOException {
        Category category;
        if (categoryPojo.getCategoryid()!= null){
            category = categoryRepo.findById(categoryPojo.getCategoryid()).orElseThrow(() ->new RuntimeException("Not Found"));
        }else {
            category=new Category();
        }
        category.setCategoryName(categoryPojo.getCategoryName());
        category.setCategoryDescription(categoryPojo.getCategoryDescription());

        if(categoryPojo.getImage()!=null){
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UploadDirectory,categoryPojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath,categoryPojo.getImage().getBytes());

            category.setImage(categoryPojo.getImage().getOriginalFilename());
        }

        categoryRepo.save(category);
        return new CategoryPojo(category);

    }

    @Override
    public List<Category> fetchAll() {
        return null;
    }

}
