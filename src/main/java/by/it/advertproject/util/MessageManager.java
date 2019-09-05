package by.it.advertproject.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {
    private static final String LOCALE_RU = "ru";
    private static final String LOCALE_EN = "en";
    private static final String FILE_NAME = "messages";
    private final static ResourceBundle resourceBundleEn = ResourceBundle
            .getBundle(FILE_NAME, new Locale(LOCALE_EN));
    private final static ResourceBundle resourceBundleRu = ResourceBundle
            .getBundle(FILE_NAME, new Locale(LOCALE_RU));

    private MessageManager() {
    }

    public static String getProperty(String key, String locale) {
        if (locale.equalsIgnoreCase(LOCALE_RU)) {
            return resourceBundleRu.getString(key);
        } else {
            return resourceBundleEn.getString(key);
        }
    }
}
