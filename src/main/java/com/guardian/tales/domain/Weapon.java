package com.guardian.tales.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "weapon")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weapon_id", columnDefinition = "int", nullable = false)
    private int weaponId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hero_info_id")
    private HeroInfo heroInfo;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "phase", length = 11)
    private Integer phase;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "weapon_type_id")
    private WeaponType weaponType;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "element_id")
    private Element element;

    @Column(name = "weapon_option", length = 300)
    private String weaponOption;

    @Column(name = "skill_name", length = 50)
    private String skillName;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chain_type_id")
    private ChainType chainType;

    @Column(name = "skill_damage", length = 11)
    private Integer skillDamage;

    @Column(name = "skill_regen_time", length = 10)
    private Float skillRegenTime;

    @Column(name = "skill_additional_effect", length = 300)
    private String skillAdditionalEffect;
}
