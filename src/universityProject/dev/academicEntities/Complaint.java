package universityProject.dev.academicEntities;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.users.User;

/**
 * @author Asyl
 * @version 18.12.2023
 * The Complaint class represents a complaint made within the academic entities of the university.
 * It contains information such as the complaint ID, text, urgency level, sender, and the accused party.
 */
public class Complaint {

    /** The unique identifier for the complaint. */
    private int complaintId;

    /** The text content of the complaint. */
    private String complaintText;

    /** The urgency level of the complaint. */
    private UrgencyLevel urgencyLevel;

    /** The ID of the user who submitted the complaint. */
    private int complaintSender;

    /** The ID of the user who is the subject of the complaint. */
    private int complaintGuilty;

    /** Default constructor for the Complaint class. */
    public Complaint() {
    }

    /**
     * Constructs a Complaint object with specified parameters.
     *
     * @param complaintText    The text content of the complaint.
     * @param urgencyLevel     The urgency level of the complaint.
     * @param complaintSender  The ID of the user who submitted the complaint.
     * @param complaintGuilty  The ID of the user who is the subject of the complaint.
     */
    public Complaint(String complaintText, UrgencyLevel urgencyLevel, int complaintSender, int complaintGuilty) {
        this.complaintId = DataRepository.getNextId();
        this.complaintText = complaintText;
        this.urgencyLevel = urgencyLevel;
        this.complaintSender = complaintSender;
        this.complaintGuilty = complaintGuilty;
    }

    /**
     * Retrieves the complaint ID.
     *
     * @return The complaint ID.
     */
    public int getComplaintId() {
        return this.complaintId;
    }

    /**
     * Retrieves the text content of the complaint.
     *
     * @return The text content of the complaint.
     */
    public String getComplaintText() {
        return this.complaintText;
    }

    /**
     * Retrieves the urgency level of the complaint.
     *
     * @return The urgency level of the complaint.
     */
    public UrgencyLevel getUrgencyLevel() {
        return this.urgencyLevel;
    }

    /**
     * Retrieves the user who submitted the complaint.
     *
     * @return The user who submitted the complaint.
     */
    public User getComplaintSender() {
        return DataRepository.getUserById(this.complaintSender);
    }

    /**
     * Retrieves the user who is the subject of the complaint.
     *
     * @return The user who is the subject of the complaint.
     */
    public User getComplaintGuilty() {
        return DataRepository.getUserById(this.complaintGuilty);
    }

    /**
     * Checks if two Complaint objects are equal based on their complaint ID.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Complaint other = (Complaint) obj;
        return complaintId == other.complaintId;
    }

    /**
     * Generates a string representation of the Complaint object.
     *
     * @return A string representation of the Complaint object.
     */
    @Override
    public String toString() {
        return "Complaint [complaintId=" + complaintId + ", complaintText=" + complaintText + ", urgencyLevel="
                + urgencyLevel + ", complaintSender=" + complaintSender + ", complaintGuilty=" + complaintGuilty + "]";
    }
}
