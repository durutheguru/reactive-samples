package com.julianduru.learning.reactive.pipeline0.data;

import com.julianduru.learning.reactive.pipeline0.util.Assert;

import java.time.ZonedDateTime;
import java.util.Locale;

/**
 * created by julian on 03/03/2022
 */
public record AbstractData(
    String id,
    Generation generation,
    String owner,
    String businessName,
    String email,
    ZonedDateTime timeStamp,
    Locale locale,
    Long streamCounter
) {

    public static AbstractData of(IdentityData id, BusinessData bd, StreamIDData sd) {
        if (!Assert.allEqual(id.streamCounter(), bd.streamCounter(), sd.streamCounter())) {
            throw new IllegalArgumentException("Stream Counter mismatch");
        }

        return new AbstractData(
            id.id(),
            id.generation(),
            bd.owner(),
            bd.businessName(),
            bd.email(),
            sd.timeStamp(),
            sd.locale(),
            sd.streamCounter()
        );
    }

}
