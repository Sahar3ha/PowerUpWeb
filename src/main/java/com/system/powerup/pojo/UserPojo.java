package com.system.powerup.pojo;

//import com.system.powerup.Entity.User;
import com.system.powerup.Entity.Membership;
import com.system.powerup.Entity.SignUp;
import com.system.powerup.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    private Integer id;
    private SignUp sign_id;
    private Membership membership_id;

    public UserPojo(User user) {
        this.id= user.getId();
        this.sign_id= user.getSignup_id();
        this.membership_id= user.getMembership_id();


    }


}
