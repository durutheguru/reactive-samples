package com.julianduru.learning.reactive.pipeline0.filter;

import com.julianduru.learning.reactive.pipeline0.data.AbstractData;
import com.julianduru.learning.reactive.pipeline0.data.Generation;
import com.julianduru.learning.reactive.pipeline0.ops.DataZipTransformer;
import com.julianduru.learning.reactive.pipeline0.util.Constants;
import reactor.core.publisher.Flux;

/**
 * created by julian on 04/03/2022
 */
public class GenerationDataFilterFactory {


    public static Flux<AbstractData> filter(Generation genFilter) {
        return DataZipTransformer.zippedStream()
            .filter(data -> data.generation() == genFilter)
            .take(genFilter.getCallCount());
    }


}
