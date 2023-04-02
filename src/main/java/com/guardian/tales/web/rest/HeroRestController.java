package com.guardian.tales.web.rest;

import com.guardian.tales.constants.Path;
import com.guardian.tales.service.HeroService;
import com.guardian.tales.service.dto.HeroDTO;
import com.guardian.tales.web.rest.vm.HeroVM;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroRestController {

    private final HeroService heroService;

    public HeroRestController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping(path = Path.HEROES, produces = "application/json")
    public List<HeroDTO.HeroInfo> getHeroesList(HeroVM.ListParam heroVM) {
        try {
            return heroService.getHeroesList(heroVM);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
