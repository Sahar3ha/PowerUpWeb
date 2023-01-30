package com.system.powerup.pojo;

import com.system.powerup.Entity.SignUp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpPojo {

    private Integer id;
    private String email;
    private String fullName;
    private String password;


    public SignUpPojo(SignUp sign) {
        this.id= sign.getId();
        this.email= sign.getEmail();
        this.fullName= sign.getFullName();
        this.password= sign.getPassword();
    }


}