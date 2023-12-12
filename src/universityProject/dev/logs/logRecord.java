package universityProject;



public class logRecord {
    private int logId;
    private String text;
    private String time;
    private int userId;

    public logRecord(int logId, String text, String time, int userId) {
        this.logId = logId;
        this.text = text;
        this.time = time;
        this.userId = userId;
    }

    private int getLogId() {
        return this.logId;
    }

    private void setLogId(Integer logId) {
        this.logId = logId;
    }

    private String getText() {
        return this.text;
    }

    private void setText(String text) {
        this.text = text;
    }

    private String getTime() {
        return this.time;
    }

    private void setTime(String time) {
        this.time = time;
    }

    private int getUserId() {
        return this.userId;
    }

    private void setUser(int userId) {
        this.userId = userId;
    }

    public void appendLog(logRecord logRecord) {
        this.text += "\n" + logRecord.getText();

        // Append time (you might want to handle time in a more sophisticated way)
        this.time += "\n" + logRecord.getTime();
    }
}
