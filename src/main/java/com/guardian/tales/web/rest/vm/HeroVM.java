package com.guardian.tales.web.rest.vm;

import lombok.Getter;
import lombok.Setter;

public class HeroVM {

    @Getter
    @Setter
    public static class ListParam {

        private String keyword;
    }
}
