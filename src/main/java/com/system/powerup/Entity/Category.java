package com.system.powerup.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @SequenceGenerator(name = "pms_user_seq_gen", sequenceName = "pms_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "pms_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer catrgoryId;

    @Column(name = "CName")
    private String categoryName;

    @Column(name = "description")
    private String categoryDescription;

    private String image;

    @Transient
    private String imageBase64;

}
