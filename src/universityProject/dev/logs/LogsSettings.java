package universityProject;

import java.io.*;

/**
 * @generated
 */
public class LogsSettings {

    /**
     * @generated
     */
    private static LogsSettings instance;

    /**
     * @generated
     */
    private static logRecord logs;

    private LogsSettings() {
        // Private constructor to prevent instantiation
    }

    /**
     * Get the singleton instance of LogsSettings
     *
     * @return The singleton instance
     */
    public static synchronized LogsSettings getInstance() {
        if (instance == null) {
            instance = new LogsSettings();
        }
        return instance;
    }

    /**
     * Add a log using serialization
     *
     * @param logRecord The log record to be added
     */
    public void addLog(logRecord logRecord) {
        // Deserialize existing logs
        logRecord existingLogs = retrieveLogs();

        // If there are existing logs, append the new log
        if (existingLogs != null) {
            // Assuming your logRecord class has a method to append logs
            existingLogs.appendLog(logRecord);
            setLogs(existingLogs);
        } else {
            // If there are no existing logs, set the new log
            setLogs(logRecord);
        }

        // Serialize and save the logs
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("logs.ser"))) {
            oos.writeObject(getLogs());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve logs from serialization
     *
     * @return The deserialized log record
     */
    public logRecord retrieveLogs() {
        // Deserialize and return the log record
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("logs.ser"))) {
            setLogs((logRecord) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return getLogs();
    }

    private logRecord getLogs() {
        return logs;
    }

    private void setLogs(logRecord logs) {
        this.logs = logs;
    }
}
