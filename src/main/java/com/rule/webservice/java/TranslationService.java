package com.rule.webservice.java;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

/**
 * Document me please
 * User: wfijarczyk
 * Date: 13.01.14
 */
public class TranslationService {




    public String translate() throws Exception {
        Translate.setClientId(PropertyHandler.getClientId());
        Translate.setClientSecret(PropertyHandler.getSecret());
        String translatedText = Translate.execute("Hello everyone", Language.ENGLISH,Language.POLISH);

        return translatedText;
    }

}
