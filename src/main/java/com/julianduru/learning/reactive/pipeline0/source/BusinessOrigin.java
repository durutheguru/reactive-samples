package com.julianduru.learning.reactive.pipeline0.source;

import com.julianduru.learning.reactive.pipeline0.data.BusinessData;
import com.julianduru.learning.reactive.pipeline0.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * created by julian on 03/03/2022
 */
public class BusinessOrigin {


    public static Flux<BusinessData> businessData() {
        return Origin.flux().flatMap(i -> Mono.fromSupplier(
            // mimic API Call
            () -> new BusinessData(
                Util.faker().name().fullName(),
                Util.faker().company().name(),
                Util.faker().internet().emailAddress(),
                i
            )
        ));
    }


}
