package com.guardian.tales.web.rest.vm;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

public class HeroVM {

    @Getter
    @Setter
    public static class ListParam {

        private String keyword;
        private Set<String> stage;
        private Set<String> role;
        private Set<String> element;
        private Set<String> weaponType;
        private Set<String> weaponSkillChainType;
        private Set<String> partyBuff;
        private Set<String> startChainType;
        private Set<String> endChainType;
    }
}
