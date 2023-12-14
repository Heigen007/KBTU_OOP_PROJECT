package universityProject.dev.logs;

import java.io.*;
import java.util.Vector;

public class LogsSettings {
    private static Vector<LogRecord> logs;

    public LogsSettings() {
    }

    /**
     * Add a log using serialization
     *
     * @param LogRecord The log record to be added
     */
    public static void addLogRecord(LogRecord LogRecord) {
        try {
            logs.add(LogRecord);
            serialize(logs, "data/logs.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void serialize(Object obj, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
        }
    }

    /**
     * Retrieve logs from serialization
     *
     * @return The deserialized log record
     */
    private static void retrieveLogs() {
        try {
            logs = (Vector<LogRecord>) deserialize("data/logs.dat");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return ois.readObject();
        }
    }

    
    public static Vector<LogRecord> getLogs() {
        if (logs == null) {
            retrieveLogs();
        }
        return logs;
    }
}
