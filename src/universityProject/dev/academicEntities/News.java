package universityProject;

public class News {

    private int newsID;
    private String title;
    private String content;
    private String comments;

    // Конструктор без параметров
    public News() {
    }

    // Конструктор с параметрами
    public News(int newsID, String title, String content, String comments, ) {
        this.newsID = newsID;
        this.title = title;
        this.content = content;
        this.comments = comments;
    }

    // Геттеры и сеттеры

    public int getNewsID() {
        return this.newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    // Операции

    public String editContent() {
        //Нужно реализовать логику редактирования контента
        return "";
    }


}
