package com.julianduru.learning.reactive.pipeline0.source;

import com.google.common.base.Strings;
import com.julianduru.learning.reactive.pipeline0.util.Constants;
import lombok.extern.java.Log;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.stream.Stream;

/**
 * created by julian on 03/03/2022
 */
@Log
public class Origin {


    private static Flux<Long> origin;


    public static void main(String[] args) {
        origin.subscribe(data -> System.out.println("Data received: " + data));
    }


    static {
        var rateMillis = System.getProperty("config.origin.rate-millis");
        origin = Flux.interval(Duration.ofMillis(Long.parseLong(rateMillis))).share();
    }


    public static Flux<Long> flux() {
        return origin;
    }


}


