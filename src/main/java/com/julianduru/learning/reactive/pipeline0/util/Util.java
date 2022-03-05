package com.julianduru.learning.reactive.pipeline0.util;

import com.github.javafaker.Faker;

/**
 * created by julian on 03/03/2022
 */
public class Util {


    private static Faker faker = new Faker();


    public static Faker faker() {
        return faker;
    }


}
