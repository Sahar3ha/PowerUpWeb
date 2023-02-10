package com.system.powerup.Entity;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
@Builder
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "signup", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_user_email", columnNames = "email")
})
public class SignUp implements UserDetails {
    @Id
    @SequenceGenerator(name = "pms_user_seq_gen", sequenceName = "pms_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "pms_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String email;


    private String fullName;

    @Column(nullable = true)
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
