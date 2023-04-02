package com.guardian.tales.repository;

import com.guardian.tales.domain.HeroInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroInfoRepository extends JpaRepository<HeroInfo, Integer>, HeroInfoRepositoryCustom {}
