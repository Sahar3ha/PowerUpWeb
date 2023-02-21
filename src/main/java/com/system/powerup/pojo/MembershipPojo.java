package com.system.powerup.pojo;

import com.system.powerup.Entity.Admin;
import com.system.powerup.Entity.Category;
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
    private Category category_id;
    private SignUp user_id;
    private Admin price_id;


//    public MembershipPojo(Membership membership) {
//        SignUp signUp;
//        this.id= membership.getId();
//        this.category= membership.getCategory();
//        this.duration=membership.getDuration();
//        this.user_id= signUp.getId();
//        this.price_id= Admin.builder().build();
////        signUp.setCategory(membership);
//    }
}
