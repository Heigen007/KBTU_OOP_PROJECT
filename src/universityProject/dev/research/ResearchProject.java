package universityProject.dev.research;

import java.util.Vector;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.users.ResearcherDecorator;

public class ResearchProject {
    private int projectID;
    private String topic;
    private Vector<Integer> publishedPapers;
    private Vector<Integer> participants;

    public ResearchProject(){
    }

    public ResearchProject(String topic) {
        this.projectID = DataRepository.getNextId();
        this.topic = topic;
        this.publishedPapers = new Vector<Integer>();
        this.participants = new Vector<Integer>();
    }

    public int getProjectID() {
        return this.projectID;
    }

    public String getTopic() {
        return this.topic;
    }

    public Vector<ResearchPaper> getPublishedPapers() {
        Vector<ResearchPaper> papers = new Vector<>();
        for (Integer paperId : this.publishedPapers) {
            ResearchPaper paper = DataRepository.getResearchPaperById(paperId);
            if (paper != null) {
                papers.add(paper);
            }
        }
        return papers;
    }

    public void addPaper(int paper) {
        this.publishedPapers.add(paper);
    }

    public Vector<ResearcherDecorator> getParticipants() {
        Vector<ResearcherDecorator> participantsTmp = new Vector<>();
        for (Integer participantId : this.participants) {
        	ResearcherDecorator participant = DataRepository.getResearcherById(participantId);
            if (participant != null) {
                participantsTmp.add(participant);
            }
        }
        return participantsTmp;
    }

    public void addParticipant(int participant) {
        this.participants.add(participant);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ResearchProject other = (ResearchProject) obj;
        return projectID == other.projectID;
    }
}
