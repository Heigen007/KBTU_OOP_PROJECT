package universityProject;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @generated
 */
public class LanguageSettings {

    /**
     * @generated
     */
    private static LanguageSettings instance;

    /**
     * @generated
     */
    private Language currentLanguage;

    /**
     * @generated
     */
    private static ResourceBundle resourceBundle;

    // Private constructor to enforce singleton pattern
    private LanguageSettings() {

    }

    // Corrected method name to follow Java conventions
    public static LanguageSettings getInstance() {
        if (instance == null) {
            instance = new LanguageSettings();
        }
        return instance;
    }

    /**
     * @generated
     */
    private void setInstance(LanguageSettings instance) {
        this.instance = instance;
    }

    /**
     * @generated
     */
    private Language getCurrentLanguage() {
        return this.currentLanguage;
    }

    /**
     * @generated
     */
    private void setCurrentLanguage(Language currentLanguage) {
        this.currentLanguage = currentLanguage;
    }

    /**
     * @generated
     */
    private ResourceBundle getResourceBundle() {
        return this.resourceBundle;
    }

    /**
     * @generated
     */
    private void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
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

    // Operations

    /**
     * @generated
     */
    public static void setCurrentLanguage(String languageCode) {
        Locale currentLocale; // Declare currentLocale
        switch (languageCode) {
            case "RU":
                currentLocale = new Locale("ru", "RU");
                break;
            case "KZ":
                currentLocale = new Locale("kz", "KZ");
                break;
            default:
                currentLocale = new Locale("en", "EN");
        }
        resourceBundle = ResourceBundle.getBundle("Messages", currentLocale);
    }

    // Corrected the return type to match the declared method
    public String getString(String key) {
        return resourceBundle.getString(key);
    }

    /**
     * @generated
     */
    public String getStringInfo() {
        // Corrected method signature and added a check for null currentLanguage
        return "Current language is " + (this.getCurrentLanguage() != null ? this.getCurrentLanguage().toString() : "not set");
    }
}
