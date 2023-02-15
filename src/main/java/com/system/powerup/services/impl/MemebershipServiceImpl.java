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
//    private final SignUpRepo signUpRepo;
//
//    private final SignUpPojo signUpPojo;

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

//    public Membership updateMember(MembershipPojo membershipPojo)throws IOException {
//        Membership membership = new Membership();
//
//        // Retrieve the parent record from Signup table
//        SignUp signUp = signUpRepo.findById(membershipPojo.getUser_id().getId())
//                .orElseThrow(() -> new RuntimeException("Signup record not found"));
//
//        if (membershipPojo.getId() != null) {
//            // Retrieve the child record from Membership table
//            membership = membershipRepo.findById(membershipPojo.getId())
//                    .orElseThrow(() -> new RuntimeException("Membership record not found"));
//        }
//
//        // Update the child record
//        membership.setCategory(membershipPojo.getCategory());
//        membership.setDuration(membershipPojo.getDuration());
//
//        // Update the parent record, if necessary
//        //signup.setSomeValue(someNewValue);
//
//        // Set the foreign key relationship
////        membership.setSignUp(signUp);
//
//        // Save the child and parent records
//        membershipRepo.save(membership);
//        signUpRepo.save(signUp);
////       return membershipRepo.update(membershipPojo.getUser_id().getId()).orElseThrow();
//
//        return new MembershipPojo(membership);
//    }




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

//    @Override
//    public void deleteById(Integer id) {
//        membershipRepo.deleteById(id);
//
//    }


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
        return membershipRepo.fetchById(id).orElseThrow();
    }



//    @Override
//    public List<Membership> fetchAll(Integer id) {
//        return membershipRepo.fetchAll(id).orElseThrow();
//    }


    public List<Membership> fetchAll() {
        return membershipRepo.findAll();
    }
}
