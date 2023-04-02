package com.guardian.tales.repository;

import com.guardian.tales.domain.ChainType;
import com.guardian.tales.domain.HeroInfo;
import com.guardian.tales.web.rest.vm.HeroVM;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HeroInfoRepositoryCustom {
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    List<HeroInfo> findByQDSLSearchValues(HeroVM.ListParam param, List<ChainType> chainTypeList);
}
