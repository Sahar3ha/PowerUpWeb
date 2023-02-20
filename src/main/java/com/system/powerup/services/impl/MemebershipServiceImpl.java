package com.system.powerup.services.impl;

import com.system.powerup.Entity.Membership;
import com.system.powerup.pojo.MembershipPojo;
import com.system.powerup.pojo.SignUpPojo;
import com.system.powerup.repo.MembershipRepo;
import com.system.powerup.repo.SignUpRepo;
import com.system.powerup.services.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemebershipServiceImpl implements MembershipService {
    private final MembershipRepo membershipRepo;

    @Override
    public MembershipPojo saveMember(MembershipPojo membershipPojo)throws IOException {
        Membership membership = new Membership();
        if (membershipPojo.getId() != null) {
            membership = membershipRepo.findById(membershipPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            membership = new Membership();
        }

        membership.setUser_id(membershipPojo.getUser_id());
        membership.setId(membership.getId());
        membership.setCategory(membershipPojo.getCategory());
        membership.setDuration(membershipPojo.getDuration());

        membershipRepo.save(membership);
        return new MembershipPojo(membership);

    }

    @Override
    public MembershipPojo updateMember(MembershipPojo membershipPojo)throws IOException {
        Membership membership = new Membership();
        if (membershipPojo.getUser_id() != null) {
            membership = membershipRepo.fetchById(membershipPojo.getUser_id().getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            membership = new Membership();
        }
        membership.setCategory(membershipPojo.getCategory());
        membership.setDuration(membershipPojo.getDuration());
        membershipRepo.save(membership);
        return new MembershipPojo(membership);
    }

    @Override
    public void deleteAllBy(Integer id) {
        membershipRepo.deleteAllBy(id);
    }

    @Override
    public Membership fetchById(Integer id) {
        return membershipRepo.fetchById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }


    public List<Membership> fetchAll() {
        return membershipRepo.findAll();
    }
}
