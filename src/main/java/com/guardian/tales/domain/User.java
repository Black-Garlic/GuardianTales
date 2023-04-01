package com.guardian.tales.domain;

import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "int", nullable = false)
    private int userId;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "login_type", length = 20)
    private String loginType;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy("hero.heroId DESC ")
    private List<UserHeroRelation> userHeroRelationList;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy("weapon.weaponId DESC ")
    private List<UserWeaponRelation> userWeaponRelationList;
}
