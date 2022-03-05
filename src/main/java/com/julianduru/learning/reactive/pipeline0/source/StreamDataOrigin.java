package com.julianduru.learning.reactive.pipeline0.source;

import com.julianduru.learning.reactive.pipeline0.data.StreamIDData;
import com.julianduru.learning.reactive.pipeline0.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.util.Locale;

/**
 * created by julian on 03/03/2022
 */
public class StreamDataOrigin {


    public static Flux<StreamIDData> streamData() {
        return Origin.flux().flatMap(i -> Mono.fromSupplier(
            () -> new StreamIDData(
                i, ZonedDateTime.now(), Locale.getDefault()
            )
        ));
    }


}
