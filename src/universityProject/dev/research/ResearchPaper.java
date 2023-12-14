package universityProject.dev.research;

import universityProject.dev.dataRepo.DataRepository;

public class ResearchPaper {
    private int paperID;
    private String title;
    private String authors;
    private String journal;
    private int pagesNumber;
    private String publicationDate;
    private String doi;
    private int citationsNumber;

    public ResearchPaper(String title, String authors, String journal, int pagesNumber, String publicationDate, String doi) {
        this.paperID = DataRepository.getNextId();
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.pagesNumber = pagesNumber;
        this.publicationDate = publicationDate;
        this.doi = doi;
        this.citationsNumber = 0;
    }

    public int getPaperID() {
        return this.paperID;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthors() {
        return this.authors;
    }

    public String getJournal() {
        return this.journal;
    }

    public int getPagesNumber() {
        return this.pagesNumber;
    }

    public String getPublicationDate() {
        return this.publicationDate;
    }

    public String getDoi() {
        return this.doi;
    }

    public int getCitationsNumber() {
        return this.citationsNumber;
    }

    public String getCitation(CiteFormat format) {
        this.citationsNumber++;
        switch (format) {
            case PLAIN_TEXT:
                return authors + ". " + title + ". " + journal + ", " + publicationDate 
                       + ". DOI:" + doi + ".";

            case BIBTEX:
                return "@article{" + paperID + ",\n" 
                       + "  author = {" + authors + "},\n" 
                       + "  title = {" + title + "},\n" 
                       + "  journal = {" + journal + "},\n" 
                       + "  year = {" + publicationDate.substring(0, 4) + "},\n" 
                       + "  pages = {" + pagesNumber + "},\n" 
                       + "  doi = {" + doi + "}\n"
                       + "}";

            default:
                return "Unknown format";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ResearchPaper other = (ResearchPaper) obj;
        return paperID == other.paperID;
    }
}
