package universityProject.dev.language;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageSettings {
    private static LanguageSettings instance;
    private Language currentLanguage;
    private static ResourceBundle resourceBundle;

    private LanguageSettings() {
    }

    public static LanguageSettings getInstance() {
        if (instance == null) {
            instance = new LanguageSettings();
        }
        return instance;
    }

    private Language getCurrentLanguage() {
        return this.currentLanguage;
    }

    public static void setCurrentLanguage(String languageCode) {
        Locale currentLocale = switch (languageCode) {
            case "RU" -> new Locale("ru", "RU");
            case "KZ" -> new Locale("kz", "KZ");
            default -> new Locale("en", "EN");
        };
        resourceBundle = ResourceBundle.getBundle("Messages", currentLocale);
    }

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