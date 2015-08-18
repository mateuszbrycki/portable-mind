package com.portablemind.helper.translation;

import com.portablemind.helper.Helper;

/**
 * Created by Mateusz Brycki on 03/06/2015.
 */
public class TranslationHelper implements Helper {
    public static String getTranslation(String translationName) {
        System.out.println("Debug");
        return "Translacja";
    }

    public static String getTranslation(String translationName, Language language) {
        return "Translacja";
    }

    public String getName() {
        return "TranslationHelper";
    }
}
