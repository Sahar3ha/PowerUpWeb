package com.system.powerup.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "membership")
public class Membership {
    @Id
    @SequenceGenerator(name = "pms_member_seq_gen", sequenceName = "pms_member_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "pms_member_seq_gen", strategy = GenerationType.SEQUENCE)


    private Integer id;
    @Column(name = "duration")
    private String duration;
    @Column(name = "category")
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_userId"))
    private SignUp user_id;


    public SignUp setSignUp(SignUp signUp) {
        return signUp;
    }
}
