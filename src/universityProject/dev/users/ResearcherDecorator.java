/**
 * The ResearcherDecorator class extends the UserDecorator class and represents a decorator for researcher objects.
 * It adds additional functionality to researchers, such as managing research papers and projects.
 *
 * @version 1.0
 * @author Zhanibek
 */
package universityProject.dev.users;

import universityProject.dev.research.*;
import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.logs.LogRecord;
import universityProject.dev.logs.LogsSettings;

import java.util.Vector;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class ResearcherDecorator extends UserDecorator {
	/**
     * The h-index of the researcher.
     */
    private Integer hIndex;
    /**
     * The identifiers of the research papers associated with the researcher.
     */
    private Vector<Integer> researchPapers;
    /**
     * The identifiers of the research projects the researcher has joined.
     */
    private Vector<Integer> researchProjects;
    /**
     * The identifier of the research supervisor for the researcher.
     */
    private Integer researchSupervisor;
    /**
     * Default constructor.
     */
    public ResearcherDecorator() {
    	createLogRecord("Researcher created");
	}
    /**
     * Parameterized constructor with the decorated user's identifier.
     *
     * @param decoratedUser The identifier of the researcher being decorated.
     */
    public ResearcherDecorator(Integer decoratedUser) {
        super(decoratedUser);
        this.researchPapers = new Vector<Integer>();
        this.researchProjects = new Vector<Integer>();
        createLogRecord("Researcher created");
    }
    /**
     * Gets the research supervisor of the researcher.
     *
     * @return The research supervisor as a ResearcherDecorator object.
     */
    public ResearcherDecorator getResearchSupervisor() {
        return DataRepository.getResearcherById(this.researchSupervisor);
    }
    /**
     * Calculates the h-index of the researcher based on their research papers' citations.
     */
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
        createLogRecord("Calculated h-index");
    }
    /**
     * Gets the h-index of the researcher.
     *
     * @return The h-index of the researcher.
     */
    public Integer getHIndex() {
        return this.hIndex;
    }
    /**
     * Submits a new research paper by creating a ResearchPaper object and adding it to the repository.
     *
     * @param title           The title of the research paper.
     * @param authors         The authors of the research paper.
     * @param journal         The journal where the research paper is published.
     * @param pagesNumber     The number of pages in the research paper.
     * @param publicationDate The publication date of the research paper.
     * @param doi             The Digital Object Identifier (DOI) of the research paper.
     */
    public void submitResearchPaper(String title, String authors, String journal, int pagesNumber, String publicationDate, String doi) {
        ResearchPaper paper = new ResearchPaper(title, authors, journal, pagesNumber, publicationDate, doi);
        this.researchPapers.add(paper.getPaperID());
        DataRepository.addResearchPaper(paper);
        createLogRecord("Submitted research paper");
    }
    /**
     * Joins a research project by adding its identifier to the researcher's list of joined projects.
     *
     * @param project The research project to join.
     */
    public void joinResearchProject(ResearchProject project) {
        this.researchProjects.add(project.getProjectID());
        createLogRecord("Joined research project");
    }
    /**
     * Assigns a research supervisor to the researcher.
     *
     * @param supervisor The research supervisor to assign.
     */
    public void assignSupervisor(ResearcherDecorator supervisor) {
        this.researchSupervisor = supervisor.decoratedUser;
        createLogRecord("Assigned research supervisor");
    }
    /**
     * Creates a new research project by creating a ResearchProject object and adding it to the repository.
     *
     * @param topic The topic of the research project.
     */
    public void createResearchProject(String topic) {
        ResearchProject project = new ResearchProject(topic);
        this.researchProjects.add(project.getProjectID());
        DataRepository.addResearchProject(project);
        createLogRecord("Created research project");
    }
    /**
     * Adds a research paper to a research project by adding its identifier to the project's list of papers.
     *
     * @param project The research project.
     * @param paper   The research paper to add to the project.
     */
    public void addPaperToProject(ResearchProject project, ResearchPaper paper) {
        project.addPaper(paper.getPaperID());
        createLogRecord("Added research paper to project");
    }
    /**
     * Prints the list of research papers associated with the researcher, sorted using the provided comparator.
     *
     * @param comparator The comparator used for sorting the research papers.
     */

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
        createLogRecord("Printed list of research papers");
    }

    public Vector<ResearchPaper> getPapers() {
        Vector<ResearchPaper> papers = new Vector<ResearchPaper>();
        for (Integer paperID : this.researchPapers) {
            papers.add(DataRepository.getResearchPaperById(paperID));
        }
        return papers;
    }

    public Vector<ResearchProject> getProjects() {
        Vector<ResearchProject> projects = new Vector<ResearchProject>();
        for (Integer projectID : this.researchProjects) {
            projects.add(DataRepository.getResearchProjectById(projectID));
        }
        return projects;
    }
    
    public void createLogRecord(String text) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        LogRecord logRecord = new LogRecord(this.decoratedUser, formattedDateTime, text);
        LogsSettings.addLogRecord(logRecord);
    }
    /**
     * Checks if this ResearcherDecorator is equal to another object.
     *
     * @param obj The object to compare with this ResearcherDecorator.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
