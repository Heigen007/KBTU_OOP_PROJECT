package universityProject;

public class ResearchProject {
    private int projectID;
    private String topic;
    private int paperID;
    private int participantsId;

    private int getProjectID() {
        return this.projectID;
    }

    private void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    private String getTopic() {
        return this.topic;
    }

    private void setTopic(String topic) {
        this.topic = topic;
    }

    private int getPaperID() {
        return this.paperID;
    }

    private void setPublishedPapers(int paperID) {
        this.paperID = paperID;
    }

    private int getParticipants() {
        return this.participantsId;
    }

    private void setParticipants(int userId) {
        this.participantsId = userId;
    }
}
