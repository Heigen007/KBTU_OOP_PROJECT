package universityProject;

public class Complaint {

    private int complaintId;
    private String complaintText;
    private UrgencyLevel urgencyLevel;
    private User complaintSender;
    private User complaintGuilty;

    // Конструктор без параметров
    public Complaint() {
    }

    // Конструктор с параметрами
    public Complaint(int complaintId, String complaintText, UrgencyLevel urgencyLevel, User complaintSender, User complaintGuilty) {
        this.complaintId = complaintId;
        this.complaintText = complaintText;
        this.urgencyLevel = urgencyLevel;
        this.complaintSender = complaintSender;
        this.complaintGuilty = complaintGuilty;
    }

    // Геттеры и сеттеры

    public int getComplaintId() {
        return this.complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintText() {
        return this.complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    public UrgencyLevel getUrgencyLevel() {
        return this.urgencyLevel;
    }

    public void setUrgencyLevel(UrgencyLevel urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public User getComplaintSender() {
        return this.complaintSender;
    }

    public void setComplaintSender(User complaintSender) {
        this.complaintSender = complaintSender;
    }

    public User getComplaintGuilty() {
        return this.complaintGuilty;
    }

    public void setComplaintGuilty(User complaintGuilty) {
        this.complaintGuilty = complaintGuilty;
    }

    // Операции

}
