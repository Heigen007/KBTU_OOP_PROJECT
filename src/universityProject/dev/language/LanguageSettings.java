package universityProject;


import java.util.ResourceBundle;

/**
* @generated
*/


public class LanguageSettings  {
    
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
    private ResourceBundle resourceBundle;
    
    
    private LanguageSettings(){

    }

    public static LanguageSettings getInstance() {
        if (instance == null) {
            instance = new LanguageSettings();
        }
        return instance;
    }
    
    /**
    * @generated
    */
    private void setInstance(LanguageSettings  instance) {
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

    // Operations
    
    /**
    * @generated
    */
    public void setCurrentLanguage() {
        //TODO
    }
    
    /**
    * @generated
    */
    public String getString() {
        return "Current language is " + this.getCurrentLanguage();
    }
    
    
}
