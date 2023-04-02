package com.guardian.tales.service.dto;

import com.guardian.tales.domain.ChainType;
import com.guardian.tales.domain.Hero;
import java.util.List;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

public class HeroDTO {

    @Getter
    @Setter
    public static class HeroInfo {

        private String name;
        private String stage;
        private String role;
        private String element;
        private String weaponPhase;
        private String weaponType;
        private String partyBuff;
        private String firstNormalAttackName;
        private String firstNormalAttackDescription;
        private String secondNormalAttackName;
        private String secondNormalAttackDescription;
        private String chainSkillName;
        private String chainSkillStartType;
        private String chainSkillEndType;
        private Integer chainSkillDamage;
        private String chainSkillDamageType;
        private String chainSkillAdditionalEffect;
        private String specialAbilityName;
        private String specialAbilityDescription;

        public HeroInfo(com.guardian.tales.domain.HeroInfo heroInfo, List<ChainType> chainTypeList) {
            this.name = heroInfo.getHero().getName();
            this.stage = heroInfo.getHero().getStage();
            this.role = heroInfo.getHero().getRole().getName();
            this.element = heroInfo.getHero().getElement().getName();

            if (heroInfo.getWeapon() != null) {
                this.weaponPhase = heroInfo.getWeapon().getPhase() + "차";
                this.weaponType = heroInfo.getWeapon().getWeaponType().getName();
            }

            this.partyBuff = heroInfo.getPartyBuff();
            this.firstNormalAttackName = heroInfo.getFirstNormalAttackName();
            this.firstNormalAttackDescription = heroInfo.getFirstNormalAttackDescription();
            this.secondNormalAttackName = heroInfo.getSecondNormalAttackName();
            this.secondNormalAttackDescription = heroInfo.getSecondNormalAttackDescription();
            this.chainSkillName = heroInfo.getChainSkillName();

            for (ChainType chainType : chainTypeList) {
                if (heroInfo.getChainSkillStartType().equals(chainType.getChainTypeId())) {
                    this.chainSkillStartType = chainType.getName();
                }

                if (heroInfo.getChainSkillEndType().equals(chainType.getChainTypeId())) {
                    this.chainSkillEndType = chainType.getName();
                }
            }

            this.chainSkillDamage = heroInfo.getChainSkillDamage();
            this.chainSkillDamageType = heroInfo.getChainSkillDamageType();
            this.chainSkillAdditionalEffect = heroInfo.getChainSkillAdditionalEffect();
            this.specialAbilityName = heroInfo.getSpecialAbilityName();
            this.specialAbilityDescription = heroInfo.getSpecialAbilityDescription();
        }
    }
}
