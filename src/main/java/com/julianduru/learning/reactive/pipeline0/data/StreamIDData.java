package com.julianduru.learning.reactive.pipeline0.data;

import java.time.ZonedDateTime;
import java.util.Locale;

/**
 * created by julian on 03/03/2022
 */
public record StreamIDData(
    Long streamCounter,
    ZonedDateTime timeStamp,
    Locale locale
) {



}
