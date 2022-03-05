package com.julianduru.learning.reactive.pipeline0.util;

import com.google.common.base.Strings;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

/**
 * created by julian on 03/03/2022
 */
@Log
public class PropertiesReader {

    private static final String DEFAULT_PATH = "application.properties";


    public static void init() {
        var path = System.getProperty("properties.data.path");
        path = !Strings.isNullOrEmpty(path) ? path : DEFAULT_PATH;

        try {
            var properties = readFromPath(path);
            for (var property : properties.stringPropertyNames()) {
                System.setProperty(property, properties.getProperty(property));
            }
        }
        catch (IOException e) {
            log.log(Level.WARNING, "Unable to load Properties file from path: " + path, e);
        }
    }


    private static Properties readFromPath(String path) throws IOException {
        var properties = new Properties();
        properties.load(PropertiesReader.class.getClassLoader().getResourceAsStream(path));

        return properties;
    }


}
