package com.system.powerup.pojo;

import com.system.powerup.Entity.Membership;
import com.system.powerup.Entity.SignUp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipPojo {
    private Integer id;
    private String category;
    private String duration;
    private SignUp user_id;


    public MembershipPojo(Membership membership) {
        this.id= membership.getId();
        this.category= membership.getCategory();
        this.duration=membership.getDuration();
        this.user_id= SignUp.builder().build();
//        signUp.setCategory(membership);
    }
}
