package universityProject.dev.research;

import universityProject.dev.dataRepo.DataRepository;

/**
 * @author Asyl
 * @version 18.12.2023
 * The ResearchPaper class represents a research paper with information such as title, authors, journal, etc.
 */
public class ResearchPaper {
    private int paperID;
    private String title;
    private String authors;
    private String journal;
    private int pagesNumber;
    private String publicationDate;
    private String doi;
    private int citationsNumber;

    /**
     * Constructs a new ResearchPaper object with the specified details.
     *
     * @param title           The title of the research paper.
     * @param authors         The authors of the research paper.
     * @param journal         The journal in which the research paper is published.
     * @param pagesNumber     The number of pages in the research paper.
     * @param publicationDate The publication date of the research paper.
     * @param doi             The DOI (Digital Object Identifier) of the research paper.
     */
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

    /**
     * Gets the unique identifier of the research paper.
     *
     * @return The paper ID.
     */
    public int getPaperID() {
        return this.paperID;
    }

    /**
     * Gets the title of the research paper.
     *
     * @return The title.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the authors of the research paper.
     *
     * @return The authors.
     */
    public String getAuthors() {
        return this.authors;
    }

    /**
     * Gets the journal in which the research paper is published.
     *
     * @return The journal.
     */
    public String getJournal() {
        return this.journal;
    }

    /**
     * Gets the number of pages in the research paper.
     *
     * @return The number of pages.
     */
    public int getPagesNumber() {
        return this.pagesNumber;
    }

    /**
     * Gets the publication date of the research paper.
     *
     * @return The publication date.
     */
    public String getPublicationDate() {
        return this.publicationDate;
    }

    /**
     * Gets the DOI (Digital Object Identifier) of the research paper.
     *
     * @return The DOI.
     */
    public String getDoi() {
        return this.doi;
    }

    /**
     * Gets the number of citations the research paper has received.
     *
     * @return The citations number.
     */
    public int getCitationsNumber() {
        return this.citationsNumber;
    }

    /**
     * Generates a citation for the research paper in the specified format.
     * Updates the citations number upon generating a citation.
     *
     * @param format The format of the citation (PLAIN_TEXT or BIBTEX).
     * @return The formatted citation.
     */
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

    /**
     * Checks if two ResearchPaper objects are equal based on their paper ID.
     *
     * @param obj The object to compare.
     * @return true if equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ResearchPaper other = (ResearchPaper) obj;
        return paperID == other.paperID;
    }

    /**
     * Returns a string representation of the ResearchPaper object.
     *
     * @return A string representation containing the details of the research paper.
     */
    @Override
    public String toString() {
        return "ResearchPaper [paperID=" + paperID + ", title=" + title + ", authors=" + authors + ", journal="
                + journal + ", pagesNumber=" + pagesNumber + ", publicationDate=" + publicationDate + ", doi=" + doi
                + ", citationsNumber=" + citationsNumber + "]";
    }
}
