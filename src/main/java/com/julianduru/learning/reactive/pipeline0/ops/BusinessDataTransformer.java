package com.julianduru.learning.reactive.pipeline0.ops;

import com.julianduru.learning.reactive.pipeline0.data.BusinessData;
import reactor.core.publisher.Flux;

import java.util.function.Function;

/**
 * created by julian on 03/03/2022
 */
public class BusinessDataTransformer implements Function<Flux<BusinessData>, Flux<BusinessData>> {


    @Override
    public Flux<BusinessData> apply(Flux<BusinessData> flux) {
        return flux.map(data -> new BusinessData(
            data.owner(), data.businessName().toUpperCase(), data.email(), data.streamCounter()
        ));
    }


}

