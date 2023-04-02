package com.guardian.tales.repository;

import com.guardian.tales.domain.ChainType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainTypeRepository extends JpaRepository<ChainType, Integer> {}
