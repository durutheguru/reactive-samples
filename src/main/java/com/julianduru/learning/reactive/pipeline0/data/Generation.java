package com.julianduru.learning.reactive.pipeline0.data;

import com.julianduru.learning.reactive.pipeline0.util.Util;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * created by julian on 03/03/2022
 */
@Getter
@RequiredArgsConstructor
public enum Generation {


    GEN1(3L),

    GEN2(5L),

    GEN3(2L);


    private final Long callCount;


    public static Generation defaultGen() {
        var values = Generation.values();
        return values[Util.faker().random().nextInt(values.length)];
    }


}
