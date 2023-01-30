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
    private String name;
    private String category;


    public MembershipPojo(Membership membership) {
        this.id= membership.getId();
        this.name= membership.getName();
        this.category= membership.getCategory();
    }
}
