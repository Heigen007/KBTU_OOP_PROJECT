package universityProject.dev.academicEntities;

import java.util.ArrayList;
import java.util.List;

import universityProject.dev.dataRepo.DataRepository;

public class News {

    private int newsID;
    private String title;
    private String content;
    private List<String> comments;

    public News() {
    }

    public News(String title, String content) {
        this.newsID = DataRepository.getNextId();
        this.title = title;
        this.content = content;
        this.comments = new ArrayList<>();
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

    public List<String> getComments() {
        return this.comments;
    }

    public void addComment(String comment) {
        this.comments.add(comment);
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
}
