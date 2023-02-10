package com.system.powerup.services;

import com.system.powerup.pojo.MembershipPojo;

import java.io.IOException;

public interface MembershipService {
    MembershipPojo saveMember(MembershipPojo membershipPojo)throws IOException;

}
