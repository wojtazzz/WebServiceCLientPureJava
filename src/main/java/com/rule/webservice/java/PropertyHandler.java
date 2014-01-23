package com.rule.webservice.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Document me please
 * User: wfijarczyk
 * Date: 23.01.14
 */
public class PropertyHandler {

    public static String getClientId() {
        return openPropertyFile().getProperty("clientid");
    }

    public static String getSecret() {
        return openPropertyFile().getProperty("clientSecret");
    }

    private static Properties openPropertyFile() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("secret.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
