package com.system.powerup.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.stream.Collectors;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User  {
    @Id
    @SequenceGenerator(name = "pms_user_seq_gen", sequenceName = "pms_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "pms_user_seq_gen", strategy = GenerationType.SEQUENCE)

    private Integer id;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "signup_id")
    private SignUp signup_id;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "membership_id")
    private Membership membership_id;


//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
//    @Column(nullable = false)
//    private Membership category;
//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
//    @Column(nullable = false)
//    private Membership duration;



}
