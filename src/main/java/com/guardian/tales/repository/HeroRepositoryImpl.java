package com.guardian.tales.repository;

import com.guardian.tales.domain.*;
import com.guardian.tales.web.rest.vm.HeroVM;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.JPQLQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class HeroRepositoryImpl extends QuerydslRepositorySupport implements HeroRepositoryCustom {

    public HeroRepositoryImpl() {
        super(Hero.class);
    }

    @Override
    public List<Hero> findByQDSLSearchValues(HeroVM.ListParam param) {
        QHero hero = QHero.hero;

        JPQLQuery<Hero> query = from(hero);

        BooleanBuilder andBuilder = new BooleanBuilder();

        if (param.getKeyword() != null && !param.getKeyword().isEmpty()) {
            BooleanBuilder orBuilder = new BooleanBuilder();

            orBuilder.or(hero.name.like("%" + param.getKeyword() + "%", '!'));

            andBuilder.and(orBuilder);
        }

        query.where(andBuilder);
        query.distinct();
        query = getQuerydsl().createQuery();
        QueryResults<Hero> result = query.fetchResults();

        return result.getResults();
    }
}
