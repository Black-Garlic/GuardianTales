package com.guardian.tales.service.mapper;

import com.guardian.tales.domain.ChainType;
import com.guardian.tales.domain.Hero;
import com.guardian.tales.domain.HeroInfo;
import com.guardian.tales.service.dto.HeroDTO;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeroMapper {

    public List<HeroDTO.HeroInfo> heroInfoListToHeroInfoDTOList(List<HeroInfo> heroInfoList) {
        return heroInfoList.stream().map(this::heroInfoToHeroInfoDTO).collect(Collectors.toList());
    }

    public HeroDTO.HeroInfo heroInfoToHeroInfoDTO(HeroInfo heroInfo) {
        return new HeroDTO.HeroInfo(heroInfo);
    }
}
