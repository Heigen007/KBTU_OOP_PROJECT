package universityProject;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageSettings {
    private static LanguageSettings instance;
    private Language currentLanguage;
    private static ResourceBundle resourceBundle; // need mark in uml as static

    /**
     * Private constructor to enforce singleton pattern
     */
    private LanguageSettings() {

    }

    /**
     * Corrected method name to follow Java conventions
     * @return
     */
    public static LanguageSettings getInstance() {
        if (instance == null) {
            instance = new LanguageSettings();
        }
        return instance;
    }

    private void setInstance(LanguageSettings instance) {
        LanguageSettings.instance = instance;
    }

    private Language getCurrentLanguage() {
        return this.currentLanguage;
    }

    private void setCurrentLanguage(Language currentLanguage) {
        this.currentLanguage = currentLanguage;
    }

    private ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    private void setResourceBundle(ResourceBundle resourceBundle) {
        LanguageSettings.resourceBundle = resourceBundle;
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

    public static void setCurrentLanguage(String languageCode) {
        Locale currentLocale = switch (languageCode) {
            case "RU" -> new Locale("ru", "RU");
            case "KZ" -> new Locale("kz", "KZ");
            default -> new Locale("en", "EN");
        }; // Declare currentLocale
        resourceBundle = ResourceBundle.getBundle("Messages", currentLocale);
    }

    // Corrected the return type to match the declared method
    public String getString(String key) {
        return resourceBundle.getString(key);
    }

    public String getStringInfo() {
        /**
         * Corrected method signature and added a check for null currentLanguage
         */
        return "Current language is " + (this.getCurrentLanguage() != null ? this.getCurrentLanguage().toString() : "not set");
    }
}
