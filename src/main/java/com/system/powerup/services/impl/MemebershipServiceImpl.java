package com.system.powerup.services.impl;

import com.system.powerup.Entity.Membership;
import com.system.powerup.Entity.SignUp;
import com.system.powerup.pojo.MembershipPojo;
import com.system.powerup.repo.MembershipRepo;
import com.system.powerup.repo.SignUpRepo;
import com.system.powerup.services.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemebershipServiceImpl implements MembershipService {
    private final MembershipRepo membershipRepo;
    private final SignUpRepo signUpRepo;

    @Override
    public void saveMember(MembershipPojo membershipPojo)throws IOException {
        Membership membership = new Membership();

        membership.setUser_id(membershipPojo.getUser_id());
        membership.setCategory(membershipPojo.getCategory());
        membership.setDuration(membershipPojo.getDuration());
        membershipRepo.save(membership);

    }




//    @Override
//    public List<Membership> findBySignUpId(SignUp signUpId) {
//        return null;
//    }

//    @Override
//    public List<Membership> findBySignUpId(SignUp signUpId) {
//        return membershipRepo.findBySignUp(signUpId);
//    }

//    @Override
//    public void deleteById(SignUp id) {
//        membershipRepo.deleteById(id.getId());
//    }

    @Override
    public void deleteById(Integer id) {
        membershipRepo.deleteById(id);

    }

//    @Override
//    public Optional<Membership> fetchById(SignUp id) {
//        return Optional.empty();
//    }

//    @Override
//    public List<Membership> fetchAll(Integer id) {
//        List<Membership> allItems = membershipRepo.fetchAll(id).orElseThrow();
//        for (Membership membership : allItems){
//            membership.setUser_id(SignUp.builder()
//                    .id(membership.getUser_id().getId())
//                    .fullName(membership.getUser_id().getFullName())
//                    .email(membership.getUser_id().getEmail())
//
//                    .build());
//        }
//        return allItems;
//    }

//    @Override
//    public Membership fetchById(Integer id) {
//        return null;
//    }

    @Override
    public Membership fetchById(Integer id) {
        return membershipRepo.fetchById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }



//    @Override
//    public List<Membership> fetchAll(Integer id) {
//        return membershipRepo.fetchAll(id).orElseThrow();
//    }


//    @Override
//    public List<Membership> fetchAll(Integer id) {
//        return membershipRepo.fetchAll(id).orElseThrow();
//    }
}
