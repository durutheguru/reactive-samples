package com.julianduru.learning.reactive.pipeline0.util;

/**
 * created by julian on 03/03/2022
 */
public class Assert {


    public static <T> boolean allEqual(T... values) {
        var first = values[0];
        for (T value : values) {
            if (!value.equals(first)) {
                return false;
            }
        }

        return true;
    }


}
