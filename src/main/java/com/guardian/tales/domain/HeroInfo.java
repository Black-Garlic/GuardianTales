package com.guardian.tales.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Getter
@Setter
@Table(name = "hero_info")
public class HeroInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hero_info_id", columnDefinition = "int", nullable = false)
    private int heroInfoId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hero_id")
    private Hero hero;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;

    @Column(name = "party_buff", length = 50)
    private String partyBuff;

    @Column(name = "first_normal_attack_name", length = 50)
    private String firstNormalAttackName;

    @Column(name = "first_normal_attack_description", length = 300)
    private String firstNormalAttackDescription;

    @Column(name = "second_normal_attack_name", length = 50)
    private String secondNormalAttackName;

    @Column(name = "second_normal_attack_description", length = 300)
    private String secondNormalAttackDescription;

    @Column(name = "chain_skill_name", length = 50)
    private String chainSkillName;

    @Column(name = "chain_skill_start_type_id", length = 11)
    private Integer chainSkillStartType;

    @Column(name = "chain_skill_end_type_id", length = 11)
    private Integer chainSkillEndType;

    @Column(name = "chain_skill_damage", length = 11)
    private Integer chainSkillDamage;

    @Column(name = "chain_skill_damage_type", length = 10)
    private String chainSkillDamageType;

    @Column(name = "chain_skill_additional_effect", length = 300)
    private String chainSkillAdditionalEffect;

    @Column(name = "special_ability_name", length = 50)
    private String specialAbilityName;

    @Column(name = "special_ability_description", length = 300)
    private String specialAbilityDescription;

    @OneToMany(mappedBy = "heroInfo", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy("weaponId DESC ")
    private List<Weapon> weaponList;
}
