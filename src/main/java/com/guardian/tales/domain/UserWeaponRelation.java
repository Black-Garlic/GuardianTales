package com.guardian.tales.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@Table(name = "user_weapon_relation")
public class UserWeaponRelation {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_weapon_id", columnDefinition = "VARCHAR(50)", nullable = false, length = 50)
    private String userWeaponId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    @Builder.Default
    private boolean own = false;
}
