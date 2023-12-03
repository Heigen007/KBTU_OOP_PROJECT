package universityProject;


/**
* @generated
*/
public class ResearchPaper {
    
    /**
    * @generated
    */
    private int paperID;
    
    /**
    * @generated
    */
    private String title;
    
    /**
    * @generated
    */
    private String authors;
    
    /**
    * @generated
    */
    private String journal;
    
    /**
    * @generated
    */
    private int pagesNumber;
    
    /**
    * @generated
    */
    private String publicationDate;
    
    /**
    * @generated
    */
    private String doi;
    
    /**
    * @generated
    */
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

    /**
    * @generated
    */
    private int getPaperID() {
        return this.paperID;
    }
    
    /**
    * @generated
    */
    private void setPaperID(Integer paperID) {
        this.paperID = paperID;
    }
    
    
    /**
    * @generated
    */
    private String getTitle() {
        return this.title;
    }
    
    /**
    * @generated
    */
    private void setTitle(String title) {
        this.title = title;
    }
    
    
    /**
    * @generated
    */
    private String getAuthors() {
        return this.authors;
    }
    
    /**
    * @generated
    */
    private void setAuthors(String authors) {
        this.authors = authors;
    }
    
    
    /**
    * @generated
    */
    private String getJournal() {
        return this.journal;
    }
    
    /**
    * @generated
    */
    private void setJournal(String journal) {
        this.journal = journal;
    }
    
    
    /**
    * @generated
    */
    private int getPagesNumber() {
        return this.pagesNumber;
    }
    
    /**
    * @generated
    */
    private void setPagesNumber(Integer pagesNumber) {
        this.pagesNumber = pagesNumber;
    }
    
    
    /**
    * @generated
    */
    private String getPublicationDate() {
        return this.publicationDate;
    }
    
    /**
    * @generated
    */
    private void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
    
    
    /**
    * @generated
    */
    private String getDoi() {
        return this.doi;
    }
    
    /**
    * @generated
    */
    private void setDoi(String doi) {
        this.doi = doi;
    }
    
    
    /**
    * @generated
    */
    private int getCitationsNumber() {
        return this.citationsNumber;
    }
    
    /**
    * @generated
    */
    private void setCitationsNumber(Integer citationsNumber) {
        this.citationsNumber = citationsNumber;
    }

    
}
