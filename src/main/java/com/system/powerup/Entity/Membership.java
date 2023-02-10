package com.system.powerup.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "membership")
public class Membership {
    @Id
    @SequenceGenerator(name = "pms_member_seq_gen", sequenceName = "pms_member_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "pms_member_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "duration")
    private String duration;


    @Column(name = "category")
    private String category;
}
