package com.system.powerup.services;

import com.system.powerup.Entity.Membership;
import com.system.powerup.pojo.MembershipPojo;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

public interface MembershipService {
    void saveMember( MembershipPojo membershipPojo)throws IOException;

    void updateMember(MembershipPojo membershipPojo)throws IOException;

    void deleteById(Integer id);

    void deleteAllBy(Integer id);

    Membership fetchById(Integer id);

    List<Membership> fetchAll();


}
