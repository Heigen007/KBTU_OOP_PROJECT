package universityProject.dev.academicEntities;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.users.User;

public class Complaint {

    private int complaintId;
    private String complaintText;
    private UrgencyLevel urgencyLevel;
    private int complaintSender;
    private int complaintGuilty;

    public Complaint() {
    }

    public Complaint(String complaintText, UrgencyLevel urgencyLevel, int complaintSender, int complaintGuilty) {
        this.complaintId = DataRepository.getNextId();
        this.complaintText = complaintText;
        this.urgencyLevel = urgencyLevel;
        this.complaintSender = complaintSender;
        this.complaintGuilty = complaintGuilty;
    }

    public int getComplaintId() {
        return this.complaintId;
    }

    public String getComplaintText() {
        return this.complaintText;
    }

    public UrgencyLevel getUrgencyLevel() {
        return this.urgencyLevel;
    }

    public User getComplaintSender() {
        return DataRepository.getUserById(this.complaintSender);
    }

    public User getComplaintGuilty() {
        return DataRepository.getUserById(this.complaintGuilty);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Complaint other = (Complaint) obj;
        return complaintId == other.complaintId;
    }

    @Override
    public String toString() {
        return "Complaint [complaintId=" + complaintId + ", complaintText=" + complaintText + ", urgencyLevel="
                + urgencyLevel + ", complaintSender=" + complaintSender + ", complaintGuilty=" + complaintGuilty + "]";
    }
}