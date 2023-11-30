package universityProject;


/**
* @generated
*/
public class logRecord {
    
    /**
    * @generated
    */
    private int logId;
    
    /**
    * @generated
    */
    private String text;
    
    /**
    * @generated
    */
    private String time;
    
    /**
    * @generated
    */
    private User user;

    public logRecord(int logId, String text, String time, User user) {
        this.logId = logId;
        this.text = text;
        this.time = time;
        this.user = user;
    }

    /**
    * @generated
    */
    private int getLogId() {
        return this.logId;
    }
    
    /**
    * @generated
    */
    private void setLogId(Integer logId) {
        this.logId = logId;
    }
    
    
    /**
    * @generated
    */
    private String getText() {
        return this.text;
    }
    
    /**
    * @generated
    */
    private void setText(String text) {
        this.text = text;
    }
    
    
    /**
    * @generated
    */
    private String getTime() {
        return this.time;
    }
    
    /**
    * @generated
    */
    private void setTime(String time) {
        this.time = time;
    }
    
    
    /**
    * @generated
    */
    private User getUser() {
        return this.user;
    }
    
    /**
    * @generated
    */
    private void setUser(User user) {
        this.user = user;
    }

    public void appendLog(logRecord logRecord) {
        this.text += "\n" + logRecord.getText();

        // Append time (you might want to handle time in a more sophisticated way)
        this.time += "\n" + logRecord.getTime();
    }
}
