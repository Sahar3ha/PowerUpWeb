package com.system.powerup.services;

import com.system.powerup.Entity.Admin;
import com.system.powerup.Entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> fetchAll();
    Category fetchById(Integer id);
}
