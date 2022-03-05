package com.julianduru.learning.reactive.pipeline0.ops;

import com.julianduru.learning.reactive.pipeline0.data.IdentityData;
import reactor.core.publisher.Flux;

import java.util.function.Function;

/**
 * created by julian on 03/03/2022
 */
public class IdentityDataTransformer implements Function<Flux<IdentityData>, Flux<IdentityData>> {


    @Override
    public Flux<IdentityData> apply(Flux<IdentityData> flux) {
        return flux.map(data -> new IdentityData(
                data.id().toUpperCase(), data.generation(), data.streamCounter()
            )
        );
    }


}
