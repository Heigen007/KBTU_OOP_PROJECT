package universityProject.dev.logs;

import universityProject.dev.dataRepo.DataRepository;


public class LogRecord {
    private int logId;
    private int userId;
    private String text;
    private String time;


    public LogRecord(int userId, String text, String time) {
        this.logId = DataRepository.getNextId();
        this.text = text;
        this.time = time;
        this.userId = userId;
    }

    private int getLogId() {
        return this.logId;
    }

    private String getText() {
        return this.text;
    }

    private String getTime() {
        return this.time;
    }

    private int getUserId() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "LogRecord{" +
                "logId=" + logId +
                ", userId=" + userId +
                ", text='" + text + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
