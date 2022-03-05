package com.julianduru.learning.reactive.pipeline0.data.nasa;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * created by julian on 05/03/2022
 */
public record APod(
    @JsonProperty("date") String date,
    @JsonProperty("explanation") String explanation,
    @JsonProperty("hdurl") String hdUrl,
    @JsonProperty("media_type") String mediaType,
    @JsonProperty("service_version") String serviceVersion,
    @JsonProperty("title") String title,
    @JsonProperty("url") String url
) {

}
