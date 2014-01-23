package com.rule.webservice.java;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Document me please
 * User: wfijarczyk
 * Date: 22.01.14
 */
public class MicroSoftTranslationTest {

    @Test
    public void connectionIsEstablishedUsingWrapper(){
         TranslationService ts = new TranslationService();

        String text = "Not translated yet";
        try {
            text = ts.translate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(text);


    }

    @Test
    public void propertiesAreReadCorrectlyFromFile(){
         assertEquals(PropertyHandler.getClientId(), "wojtaz");
        assertEquals(PropertyHandler.getSecret(),"O74jJR25fF7NHiMAhWV3AyhBU/i9+e77kabNYiRzZzg=");

    }

}
