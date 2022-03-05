package com.julianduru.learning.reactive.pipeline0.ops;

import com.julianduru.learning.reactive.pipeline0.data.AbstractData;
import com.julianduru.learning.reactive.pipeline0.data.BusinessData;
import com.julianduru.learning.reactive.pipeline0.data.IdentityData;
import com.julianduru.learning.reactive.pipeline0.data.StreamIDData;
import com.julianduru.learning.reactive.pipeline0.source.BusinessOrigin;
import com.julianduru.learning.reactive.pipeline0.source.IdentityOrigin;
import com.julianduru.learning.reactive.pipeline0.source.StreamDataOrigin;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * created by julian on 03/03/2022
 */
public class DataZipTransformer {


    public static Flux<AbstractData> zippedStream() {
        return Flux.zip(
            List.of(
                IdentityOrigin.identityData().transform(new IdentityDataTransformer()),
                BusinessOrigin.businessData().transform(new BusinessDataTransformer()),
                StreamDataOrigin.streamData()
            ),

            objects -> AbstractData.of(
                (IdentityData) objects[0],
                (BusinessData) objects[1],
                (StreamIDData) objects[2]
            )
        );
    }


}
