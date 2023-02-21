package com.system.powerup.services.impl;

import com.system.powerup.Entity.Admin;
import com.system.powerup.Entity.Category;
import com.system.powerup.repo.CategoryRepo;
import com.system.powerup.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    public List<Category> fetchAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category fetchById(Integer id) {
        return categoryRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }
}
