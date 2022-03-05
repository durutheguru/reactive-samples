package com.julianduru.learning.reactive;


import com.julianduru.learning.reactive.pipeline0.data.Generation;
import com.julianduru.learning.reactive.pipeline0.filter.GenerationDataFilterFactory;
import com.julianduru.learning.reactive.pipeline0.util.PropertiesReader;

public class Main {

    public static void main(String[] args) throws Exception {
        PropertiesReader.init();

        GenerationDataFilterFactory
            .filter(Generation.GEN1)
            .subscribe(data -> System.out.println("Gen1 Data Received: " + data));

        GenerationDataFilterFactory
            .filter(Generation.GEN2)
            .subscribe(data -> System.out.println("Gen2 Data Received: " + data));

        GenerationDataFilterFactory
            .filter(Generation.GEN3)
            .subscribe(data -> System.out.println("Gen3 Data Received: " + data));

        Thread.sleep(100000L);
    }


}
