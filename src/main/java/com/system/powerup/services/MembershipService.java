package com.system.powerup.services;

import com.system.powerup.Entity.Membership;
import com.system.powerup.Entity.SignUp;
import com.system.powerup.pojo.MembershipPojo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface MembershipService {
    void saveMember(MembershipPojo membershipPojo)throws IOException;
    void deleteById(Integer id);

    Membership fetchById(Integer id);

//    List<Membership> fetchAll(Integer id);


}
