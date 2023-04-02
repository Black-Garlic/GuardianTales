package com.guardian.tales.repository;

import com.guardian.tales.domain.Hero;
import com.guardian.tales.domain.HeroInfo;
import com.guardian.tales.domain.QHero;
import com.guardian.tales.domain.QHeroInfo;
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

        JPQLQuery<HeroInfo> query = from(heroInfo);
        query.leftJoin(hero).on(heroInfo.hero.eq(hero));

        BooleanBuilder andBuilder = new BooleanBuilder();

        if (param.getKeyword() != null && !param.getKeyword().isEmpty()) {
            BooleanBuilder orBuilder = new BooleanBuilder();

            orBuilder.or(hero.name.like("%" + param.getKeyword() + "%", '!'));

            andBuilder.and(orBuilder);
        }

        query.where(andBuilder);
        query.distinct();
        QueryResults<HeroInfo> result = query.fetchResults();

        return result.getResults();
    }
}
