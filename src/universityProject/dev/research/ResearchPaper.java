package universityProject;

public class ResearchPaper {
    private int paperID;
    private String title;
    private String authors;
    private String journal;
    private int pagesNumber;
    private String publicationDate;
    private String doi;
    private int citationsNumber;

    public ResearchPaper(int paperID, String title, String authors, String journal, int pagesNumber, String publicationDate, String doi, int citationsNumber) {
        this.paperID = paperID;
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.pagesNumber = pagesNumber;
        this.publicationDate = publicationDate;
        this.doi = doi;
        this.citationsNumber = citationsNumber;
    }

    private int getPaperID() {
        return this.paperID;
    }

    private void setPaperID(int paperID) {
        this.paperID = paperID;
    }

    private String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private String getAuthors() {
        return this.authors;
    }

    private void setAuthors(String authors) {
        this.authors = authors;
    }

    private String getJournal() {
        return this.journal;
    }

    private void setJournal(String journal) {
        this.journal = journal;
    }

    private int getPagesNumber() {
        return this.pagesNumber;
    }

    private void setPagesNumber(Integer pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    private String getPublicationDate() {
        return this.publicationDate;
    }

    private void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    private String getDoi() {
        return this.doi;
    }

    private void setDoi(String doi) {
        this.doi = doi;
    }

    private int getCitationsNumber() {
        return this.citationsNumber;
    }

    private void setCitationsNumber(Integer citationsNumber) {
        this.citationsNumber = citationsNumber;
    }
}
