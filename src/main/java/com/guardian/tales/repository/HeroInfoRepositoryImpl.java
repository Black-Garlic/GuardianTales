package com.guardian.tales.repository;

import com.guardian.tales.domain.*;
import com.guardian.tales.web.rest.vm.HeroVM;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.JPQLQuery;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class HeroInfoRepositoryImpl extends QuerydslRepositorySupport implements HeroInfoRepositoryCustom {

    public HeroInfoRepositoryImpl() {
        super(HeroInfo.class);
    }

    @Override
    public List<HeroInfo> findByQDSLSearchValues(HeroVM.ListParam param) {
        QHeroInfo heroInfo = QHeroInfo.heroInfo;
        QHero hero = QHero.hero;
        QRole role = QRole.role;
        QElement element = QElement.element;
        QWeapon weapon = QWeapon.weapon;
        QWeaponType weaponType = QWeaponType.weaponType;
        QChainType chainType = QChainType.chainType;

        JPQLQuery<HeroInfo> query = from(heroInfo);
        query.leftJoin(hero).on(heroInfo.hero.eq(hero));
        query.leftJoin(role).on(hero.role.eq(role));
        query.leftJoin(element).on(hero.element.eq(element));
        query.leftJoin(weapon).on(heroInfo.weapon.eq(weapon));
        query.leftJoin(weaponType).on(weapon.weaponType.eq(weaponType));
        query.leftJoin(chainType).on(weapon.chainType.eq(chainType));

        BooleanBuilder andBuilder = new BooleanBuilder();

        // 키워드 검색
        if (param.getKeyword() != null && !param.getKeyword().isEmpty()) {
            BooleanBuilder orBuilder = new BooleanBuilder();

            orBuilder.or(hero.name.like("%" + param.getKeyword() + "%", '!'));

            andBuilder.and(orBuilder);
        }

        // 등급 필터
        if (param.getStage() != null && param.getStage().size() > 0) {
            BooleanBuilder orBuilder = new BooleanBuilder();

            for (String stageName : param.getStage()) {
                orBuilder.or(heroInfo.hero.stage.eq(stageName));
            }

            andBuilder.and(orBuilder);
        }

        // 역할 필터
        if (param.getRole() != null && param.getRole().size() > 0) {
            BooleanBuilder orBuilder = new BooleanBuilder();

            for (String roleName : param.getRole()) {
                orBuilder.or(heroInfo.hero.role.name.eq(roleName));
            }

            andBuilder.and(orBuilder);
        }

        // 속성 필터
        if (param.getElement() != null && param.getElement().size() > 0) {
            BooleanBuilder orBuilder = new BooleanBuilder();

            for (String elementName : param.getElement()) {
                orBuilder.or(heroInfo.hero.element.name.eq(elementName));
            }

            andBuilder.and(orBuilder);
        }

        // 무기 종류 필터
        if (param.getWeaponType() != null && param.getWeaponType().size() > 0) {
            BooleanBuilder orBuilder = new BooleanBuilder();

            for (String weaponTypeName : param.getWeaponType()) {
                orBuilder.or(heroInfo.weapon.weaponType.name.eq(weaponTypeName));
            }

            andBuilder.and(orBuilder);
        }

        // 무기 스킬 타입 필터
        if (param.getWeaponSkillChainType() != null && param.getWeaponSkillChainType().size() > 0) {
            BooleanBuilder orBuilder = new BooleanBuilder();

            for (String weaponSkillChainTypeName : param.getWeaponSkillChainType()) {
                orBuilder.or(heroInfo.weapon.chainType.name.eq(weaponSkillChainTypeName));
            }

            andBuilder.and(orBuilder);
        }

        // 파티 버프
        if (param.getPartyBuff() != null && param.getPartyBuff().size() > 0) {
            BooleanBuilder orBuilder = new BooleanBuilder();

            for (String weaponSkillChainTypeName : param.getPartyBuff()) {
                orBuilder.or(heroInfo.partyBuff.like("%" + weaponSkillChainTypeName + "%", '!'));
            }

            andBuilder.and(orBuilder);
        }

        //        // 연계기 시작 타입 필터
        //        if (param.getStartChainType() != null && param.getStartChainType().size() > 0) {
        //            BooleanBuilder orBuilder = new BooleanBuilder();
        //
        //            for (String  : param.getStartChainType()) {
        //                orBuilder.or(heroInfo.hero.stage.eq(stage));
        //            }
        //
        //            andBuilder.and(orBuilder);
        //        }
        //
        //        // 연계기 종료 타입 필터
        //        if (param.getStage() != null && param.getStage().size() > 0) {
        //            BooleanBuilder orBuilder = new BooleanBuilder();
        //
        //            for (String stage : param.getStage()) {
        //                orBuilder.or(heroInfo.hero.stage.eq(stage));
        //            }
        //
        //            andBuilder.and(orBuilder);
        //        }

        query.where(andBuilder);
        query.distinct();
        QueryResults<HeroInfo> result = query.fetchResults();

        return result.getResults();
    }
}
