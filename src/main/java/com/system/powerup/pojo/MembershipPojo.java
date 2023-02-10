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
    private String duration;
    private String email;


    public MembershipPojo(Membership membership) {
        this.id= membership.getId();
        this.name= membership.getName();
        this.category= membership.getCategory();
        this.email=membership.getEmail();
        this.duration=membership.getDuration();
    }
}
