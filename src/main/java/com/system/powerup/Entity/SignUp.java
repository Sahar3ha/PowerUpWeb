package com.system.powerup.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "signup" )

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


//    @OneToMany(cascade = CascadeType.ALL)
////    @JoinColumn(name = "mId")
//    private List<Membership> childEntities;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "category", referencedColumnName = "category")
//    private Membership category;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "duration" , referencedColumnName = "duration")
//    private Membership duration;

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
