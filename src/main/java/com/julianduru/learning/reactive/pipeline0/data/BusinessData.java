package com.julianduru.learning.reactive.pipeline0.data;

/**
 * created by julian on 03/03/2022
 */
public record BusinessData(
    String owner,
    String businessName,
    String email,
    Long streamCounter
) {
}
