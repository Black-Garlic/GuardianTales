package com.guardian.tales.service;

import com.guardian.tales.domain.HeroInfo;
import com.guardian.tales.repository.HeroInfoRepository;
import com.guardian.tales.service.dto.HeroDTO;
import com.guardian.tales.service.mapper.HeroMapper;
import com.guardian.tales.web.rest.vm.HeroVM;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HeroService {

    private final HeroInfoRepository heroInfoRepository;
    private final HeroMapper heroMapper;

    public HeroService(HeroInfoRepository heroInfoRepository, HeroMapper heroMapper) {
        this.heroInfoRepository = heroInfoRepository;
        this.heroMapper = heroMapper;
    }

    public List<HeroDTO.HeroInfo> getHeroesList(HeroVM.ListParam heroVM) {
        List<HeroInfo> heroInfoList = heroInfoRepository.findByQDSLSearchValues(heroVM);

        return heroMapper.heroInfoListToHeroInfoDTOList(heroInfoList);
    }
}
