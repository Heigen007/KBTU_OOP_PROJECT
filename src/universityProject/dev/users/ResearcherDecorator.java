package universityProject.dev.users;

import universityProject.dev.research.*;
import universityProject.dev.dataRepo.DataRepository;

import java.util.Vector;
import java.util.Collections;

public class ResearcherDecorator extends UserDecorator {
    private Integer hIndex;
    private Vector<Integer> researchPapers;
    private Vector<Integer> researchProjects;
    private Integer researchSupervisor;

    public ResearcherDecorator() {
	}
    public ResearcherDecorator(Integer decoratedUser) {
        super(decoratedUser);
    }

    public ResearcherDecorator getResearchSupervisor() {
        return DataRepository.getResearcherById(this.researchSupervisor);
    }

    public void calculateHIndex() {
        Vector<ResearchPaper> papers = new Vector<ResearchPaper>();
        for (Integer paperID : this.researchPapers) {
            papers.add(DataRepository.getResearchPaperById(paperID));
        }
        int hIndex = 0;
        for (ResearchPaper paper : papers) {
            if (paper.getCitationsNumber() > hIndex) {
                hIndex = paper.getCitationsNumber();
            }
        }
        this.hIndex = hIndex;
    }

    public Integer getHIndex() {
        return this.hIndex;
    }

    public void submitResearchPaper(String title, String authors, String journal, int pagesNumber, String publicationDate, String doi) {
        ResearchPaper paper = new ResearchPaper(title, authors, journal, pagesNumber, publicationDate, doi);
        DataRepository.addResearchPaper(paper);
    }

    public void joinResearchProject(ResearchProject project) {
        this.researchProjects.add(project.getProjectID());
    }

    public void assignSupervisor(ResearcherDecorator supervisor) {
        this.researchSupervisor = supervisor.decoratedUser;
    }

    public void createResearchProject(String topic) {
        ResearchProject project = new ResearchProject(topic);
        DataRepository.addResearchProject(project);
    }

    public void addPaperToProject(ResearchProject project, ResearchPaper paper) {
        project.addPaper(paper.getPaperID());
    }

    public void printPapers(ResearchPaperComporator comparator) {
        Vector<ResearchPaper> papers = new Vector<ResearchPaper>();
        for (Integer paperID : this.researchPapers) {
            papers.add(DataRepository.getResearchPaperById(paperID));
        }
        Collections.sort(papers, comparator);
        System.out.println("Papers for " + super.getDecoratedUser().getUserName());
        System.out.println("-------------------------------");
        for (ResearchPaper paper : papers) {
            System.out.println(paper);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
