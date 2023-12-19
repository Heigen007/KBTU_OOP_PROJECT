package universityProject.dev.language;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The LanguageSettings class manages the language settings for the application.
 * It provides methods to set the current language and retrieve localized strings.
 */
public class LanguageSettings {
    private static LanguageSettings instance;
    private Language currentLanguage;
    private static ResourceBundle resourceBundle;

    /**
     * Private constructor to enforce the singleton pattern.
     */
    private LanguageSettings() {
    }

    /**
     * Retrieves the singleton instance of the LanguageSettings class.
     *
     * @return The singleton instance of LanguageSettings.
     */
    public static LanguageSettings getInstance() {
        if (instance == null) {
            instance = new LanguageSettings();
        }
        return instance;
    }

    /**
     * Retrieves the current language.
     *
     * @return The current language.
     */
    private Language getCurrentLanguage() {
        return this.currentLanguage;
    }

    /**
     * Sets the current language based on the provided language code.
     * Default language is English if the provided code is not recognized.
     *
     * @param languageCode The language code (e.g., "RU", "KZ", "EN").
     */
    public static void setCurrentLanguage(String languageCode) {
        Locale currentLocale = switch (languageCode) {
            case "RU" -> new Locale("ru", "RU");
            case "KZ" -> new Locale("kz", "KZ");
            default -> new Locale("en", "EN");
        };
        resourceBundle = ResourceBundle.getBundle("Messages", currentLocale);
    }

    /**
     * Retrieves the localized string for the given key.
     *
     * @param key The key corresponding to the desired localized string.
     * @return The localized string.
     */
    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}


// Examples

//    public static void main(String[] args) {
//        setCurrentLanguage("RU");
//        displayMessages();
//
//        setCurrentLanguage("KZ");
//        displayMessages();
//
//        setCurrentLanguage("EN");
//        displayMessages();
//    }
//    public static void displayMessages() {
//        String greetingMessage = resourceBundle.getString("greeting");
//        String farewellMessage = resourceBundle.getString("farewell");
//
//        System.out.println("Greeting: " + greetingMessage);
//        System.out.println("Farewell: " + farewellMessage);
//        System.out.println();
//    }
