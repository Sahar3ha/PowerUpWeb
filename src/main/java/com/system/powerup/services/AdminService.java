package com.system.powerup.services;

import com.system.powerup.Entity.Admin;
import com.system.powerup.pojo.AdminPojo;

import java.util.List;


public interface AdminService {
    AdminPojo save(AdminPojo adminPojo) ;

    List<Admin> fetchAll();
    Admin fetchById(Integer id);



    void deleteById(Integer id);


}
