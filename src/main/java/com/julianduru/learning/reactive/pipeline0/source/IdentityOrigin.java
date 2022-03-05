package com.julianduru.learning.reactive.pipeline0.source;

import com.julianduru.learning.reactive.pipeline0.data.Generation;
import com.julianduru.learning.reactive.pipeline0.data.IdentityData;
import com.julianduru.learning.reactive.pipeline0.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * created by julian on 03/03/2022
 */
public class IdentityOrigin {


    public static Flux<IdentityData> identityData() {
        return Origin.flux().flatMap(i -> Mono.fromSupplier(
                // mimic API call.
                () -> new IdentityData(
                    Util.faker().code().isbn10(false),
                    Generation.defaultGen(), i
                )
            )
        );
    }


}
