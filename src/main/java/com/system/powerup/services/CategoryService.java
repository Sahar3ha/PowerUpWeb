package com.system.powerup.services;

import com.system.powerup.Entity.Admin;
import com.system.powerup.Entity.Category;

public interface CategoryService {
    Category fetchById(Integer id);
}
