package com.guardian.tales.repository;

import com.guardian.tales.domain.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer>, HeroRepositoryCustom {}
