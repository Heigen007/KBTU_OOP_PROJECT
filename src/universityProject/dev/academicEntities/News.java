package universityProject.dev.academicEntities;

import java.io.Serializable;
import java.util.Vector;

import universityProject.dev.dataRepo.DataRepository;

/**
 * @author Asyl
 * @version 18.12.2023
 * The News class represents a news article within the academic entities of the university.
 * It contains information such as the news ID, title, content, comments, and topic.
 */
public class News implements Serializable {

    /** The unique identifier for the news article. */
    private int newsID;

    /** The title of the news article. */
    private String title;

    /** The content of the news article. */
    private String content;

    /** The comments associated with the news article. */
    private Vector<String> comments;

    /** The topic of the news article. */
    private NewsTopic topic;

    /** Default constructor for the News class. */
    public News() {
    }

    /**
     * Constructs a News object with specified parameters.
     *
     * @param title   The title of the news article.
     * @param content The content of the news article.
     * @param topic   The topic of the news article.
     */
    public News(String title, String content, NewsTopic topic) {
        this.newsID = DataRepository.getNextId();
        this.title = title;
        this.content = content;
        this.topic = topic;
        this.comments = new Vector<>();
    }

    /**
     * Retrieves the news ID.
     *
     * @return The news ID.
     */
    public int getNewsId() {
        return this.newsID;
    }

    /**
     * Retrieves the title of the news article.
     *
     * @return The title of the news article.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Retrieves the content of the news article.
     *
     * @return The content of the news article.
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Retrieves the comments associated with the news article.
     *
     * @return A vector containing the comments associated with the news article.
     */
    public Vector<String> getComments() {
        return this.comments;
    }

    /**
     * Adds a comment to the news article.
     *
     * @param comment The comment to be added.
     */
    public void addComment(String comment) {
        this.comments.add(comment);
    }

    /**
     * Retrieves the topic of the news article.
     *
     * @return The topic of the news article.
     */
    public NewsTopic getTopic() {
        return this.topic;
    }

    /**
     * Checks if two News objects are equal based on their news ID.
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
        News other = (News) obj;
        return newsID == other.newsID;
    }

    /**
     * Generates a string representation of the News object.
     *
     * @return A string representation of the News object.
     */
    @Override
    public String toString() {
        return "News [newsID=" + newsID + ", title=" + title + ", content=" + content + ", comments=" + comments
                + ", topic=" + topic + "]";
    }
}
