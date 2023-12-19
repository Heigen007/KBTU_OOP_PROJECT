package universityProject.dev.logs;

import universityProject.dev.dataRepo.DataRepository;

/**
 * @author Asyl
 * @version 18.12.2023
 * The LogRecord class represents a log entry in the application.
 * It contains information such as log ID, user ID, log text, and timestamp.
 */
public class LogRecord {
    private int logId;
    private int userId;
    private String text;
    private String time;

    /**
     * Constructs a LogRecord object with the specified user ID, log text, and timestamp.
     *
     * @param userId The ID of the user associated with the log entry.
     * @param text   The text content of the log entry.
     * @param time   The timestamp indicating when the log entry was created.
     */
    public LogRecord(int userId, String text, String time) {
        this.logId = DataRepository.getNextId();
        this.text = text;
        this.time = time;
        this.userId = userId;
    }

    /**
     * Gets the log ID associated with this log entry.
     *
     * @return The log ID.
     */
    public int getLogId() {
        return this.logId;
    }

    /**
     * Gets the text content of the log entry.
     *
     * @return The log text.
     */
    public String getText() {
        return this.text;
    }

    /**
     * Gets the timestamp indicating when the log entry was created.
     *
     * @return The timestamp.
     */
    public String getTime() {
        return this.time;
    }

    /**
     * Gets the user ID associated with this log entry.
     *
     * @return The user ID.
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * Returns a string representation of the LogRecord.
     *
     * @return A string representation containing log ID, user ID, log text, and time.
     */
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
