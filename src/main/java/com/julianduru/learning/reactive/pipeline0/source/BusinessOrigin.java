package com.julianduru.learning.reactive.pipeline0.source;

import com.julianduru.learning.reactive.pipeline0.data.BusinessData;
import com.julianduru.learning.reactive.pipeline0.data.nasa.APod;
import com.julianduru.learning.reactive.pipeline0.util.JsonBodyHandler;
import com.julianduru.learning.reactive.pipeline0.util.Util;
import lombok.extern.java.Log;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.logging.Level;

/**
 * created by julian on 03/03/2022
 */
@Log
public class BusinessOrigin {


    public static Flux<BusinessData> businessData() {
        return Origin.flux().flatMap(i -> Mono.fromSupplier(
            () -> new BusinessData(
                Util.faker().name().fullName(),
                Util.faker().company().name(),
                getEmailOrUrl(),
                i
            )
        ));
    }


    private static String getEmailOrUrl() {
        var call = (Util.faker().random().nextInt(2) % 2) == 0;
        if (call) {
            return readUrlFromAPI();
        }

        return Util.faker().internet().emailAddress();
    }


    private static String readUrlFromAPI() {
        try {
            var client = HttpClient.newHttpClient();
            var request = HttpRequest
                .newBuilder(URI.create(System.getProperty("config.api.nasa.rest-url")))
                .header("accept", "application/json")
                .build();

            var response = client.send(request, new JsonBodyHandler<>(APod.class));
            return response.body().get().url();
        } catch (IOException | InterruptedException ex) {
            log.log(Level.SEVERE, "Error occurred while calling NASA API", ex);
            throw new RuntimeException(ex);
        }
    }


}
