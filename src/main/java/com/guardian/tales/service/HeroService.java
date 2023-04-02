package com.guardian.tales.service;

import com.guardian.tales.domain.ChainType;
import com.guardian.tales.domain.HeroInfo;
import com.guardian.tales.repository.ChainTypeRepository;
import com.guardian.tales.repository.HeroInfoRepository;
import com.guardian.tales.service.dto.HeroDTO;
import com.guardian.tales.service.mapper.HeroMapper;
import com.guardian.tales.web.rest.vm.HeroVM;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HeroService {

    private final HeroInfoRepository heroInfoRepository;
    private final ChainTypeRepository chainTypeRepository;
    private final HeroMapper heroMapper;

    public HeroService(HeroInfoRepository heroInfoRepository, ChainTypeRepository chainTypeRepository, HeroMapper heroMapper) {
        this.heroInfoRepository = heroInfoRepository;
        this.chainTypeRepository = chainTypeRepository;
        this.heroMapper = heroMapper;
    }

    public List<HeroDTO.HeroInfo> getHeroesList(HeroVM.ListParam heroVM) {
        List<ChainType> chainTypeList = chainTypeRepository.findAll();

        List<HeroInfo> heroInfoList = heroInfoRepository.findByQDSLSearchValues(heroVM, chainTypeList);

        return heroMapper.heroInfoListToHeroInfoDTOList(heroInfoList, chainTypeList);
    }
}
