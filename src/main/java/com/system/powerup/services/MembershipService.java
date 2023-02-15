package com.system.powerup.services;

import com.system.powerup.Entity.Membership;
import com.system.powerup.pojo.MembershipPojo;

import java.io.IOException;
import java.util.List;

public interface MembershipService {
    MembershipPojo saveMember(MembershipPojo membershipPojo)throws IOException;


    MembershipPojo updateMember(MembershipPojo membershipPojo)throws IOException;

    void deleteAllBy(Integer id);

    Membership fetchById(Integer id);

    List<Membership> fetchAll();


}
