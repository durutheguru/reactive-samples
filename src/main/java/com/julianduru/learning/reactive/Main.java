package com.julianduru.learning.reactive;


import com.julianduru.learning.reactive.pipeline0.data.Generation;
import com.julianduru.learning.reactive.pipeline0.filter.GenerationDataFilterFactory;
import com.julianduru.learning.reactive.pipeline0.util.PropertiesReader;
import lombok.extern.java.Log;

@Log
public class Main {

    public static void main(String[] args) throws Exception {
        PropertiesReader.init();

        GenerationDataFilterFactory
            .filter(Generation.GEN1)
            .subscribe(
                data -> System.out.println("Gen1 Data Received: " + data),
                ex -> log.warning("Error Thrown: " + ex.getMessage())
            );

        GenerationDataFilterFactory
            .filter(Generation.GEN2)
            .subscribe(
                data -> System.out.println("Gen2 Data Received: " + data),
                ex -> log.warning("Error Thrown: " + ex.getMessage())
            );

        GenerationDataFilterFactory
            .filter(Generation.GEN3)
            .subscribe(
                data -> System.out.println("Gen3 Data Received: " + data),
                ex -> log.warning("Error Thrown: " + ex.getMessage())
            );

        Thread.sleep(10000L);
    }


}

