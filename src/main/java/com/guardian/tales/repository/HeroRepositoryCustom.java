package com.guardian.tales.repository;

import com.guardian.tales.domain.Hero;
import com.guardian.tales.web.rest.vm.HeroVM;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HeroRepositoryCustom {
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    List<Hero> findByQDSLSearchValues(HeroVM.ListParam param);
}
