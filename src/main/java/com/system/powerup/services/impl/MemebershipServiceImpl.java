package com.system.powerup.services.impl;

import com.system.powerup.Entity.Membership;
import com.system.powerup.pojo.MembershipPojo;
import com.system.powerup.repo.MembershipRepo;
import com.system.powerup.services.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemebershipServiceImpl implements MembershipService {
    private final MembershipRepo membershipRepo;
    @Override
    public String saveMember(MembershipPojo membershipPojo) {
        Membership membership = new Membership();
        membership.setName(membership.getName());
        membership.setCategory(membership.getCategory());
        membershipRepo.save(membership);
        return "creates";

    }
}
