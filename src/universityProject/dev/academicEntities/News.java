package universityProject.dev.academicEntities;

import java.util.Vector;

import universityProject.dev.dataRepo.DataRepository;

public class News {

    private int newsID;
    private String title;
    private String content;
    private Vector<String> comments;
    private NewsTopic topic;

    public News() {
    }

    public News(String title, String content, NewsTopic topic) {
        this.newsID = DataRepository.getNextId();
        this.title = title;
        this.content = content;
        this.topic = topic;
        this.comments = new Vector<>();
    }

    public int getNewsId() {
        return this.newsID;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public Vector<String> getComments() {
        return this.comments;
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }

    public NewsTopic getTopic() {
        return this.topic;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        News other = (News) obj;
        return newsID == other.newsID;
    }

    @Override
    public String toString() {
        return "News [newsID=" + newsID + ", title=" + title + ", content=" + content + ", comments=" + comments
                + ", topic=" + topic + "]";
    }
}
