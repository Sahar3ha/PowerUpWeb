package com.system.powerup.services.impl;

import com.system.powerup.Entity.Membership;
import com.system.powerup.pojo.MembershipPojo;
import com.system.powerup.repo.MembershipRepo;
import com.system.powerup.services.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MemebershipServiceImpl implements MembershipService {
    private final MembershipRepo membershipRepo;
    @Override
    public MembershipPojo saveMember(MembershipPojo membershipPojo)throws IOException {
        Membership membership = new Membership();
        membership.setName(membershipPojo.getName());
        membership.setCategory(membershipPojo.getCategory());
        membership.setEmail(membershipPojo.getEmail());
        membership.setDuration(membershipPojo.getDuration());
        membershipRepo.save(membership);
        return new MembershipPojo(membership);
    }
}
