package com.guardian.tales.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "weapon_type")
public class WeaponType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weapon_type_id", columnDefinition = "int", nullable = false)
    private int weaponTypeId;

    @Column(name = "name", length = 20)
    private String name;
}
