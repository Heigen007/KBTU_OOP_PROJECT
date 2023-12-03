package universityProject;

public class News {

    private int newsID;
    private String title;
    private String content;
    private List<String> comments;

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


// Operations
public void publishNews(String newContent, String newComments) {
        if (isValidContent(newContent) && isValidComment(newComments)) {
            System.out.println("News published or updated successfully.");
            System.out.println("Old content: " + content + ", New content: " + newContent);
            System.out.println("Old comments: " + comments + ", New comments: " + newComments);
            this.content = newContent;
            this.comments = newComments;
        } else {
            System.out.println("Invalid content or comments provided. News not published or updated.");
        }
    }

    // Validation method for content
    private boolean isValidContent(String newContent) {
        return newContent != null && !newContent.trim().isEmpty() && newContent.length() <= 1000;
    }

    // Validation method for comments
    private boolean isValidComment(String newComment) {
        return newComment != null && !newComment.trim().isEmpty() && newComment.length() <= 500;
    }

 // Operation to edit the content of the news article with validation
    public void editContent(String newContent) {
        if (isValidContent(newContent)) {
            this.content = newContent;
            System.out.println("Content edited successfully.");
        } else {
            System.out.println("Invalid content. Please provide valid content.");
        }
    }

    // Validation method for content
    private boolean isValidContent(String newContent) {
        return newContent != null && !newContent.trim().isEmpty() && newContent.length() <= 1000;
    }
 // Operation to add a comment to the news article
    public void addComment(String newComment) {
        if (isValidComment(newComment)) {
            if (comments == null) {
                comments = new ArrayList<>();
            }
            comments.add(newComment);
            System.out.println("Comment added successfully.");
        } else {
            System.out.println("Invalid comment. Please provide a valid comment.");
        }
    }

    // Validation method for comments
    private boolean isValidComment(String newComment) {
        return newComment != null && !newComment.trim().isEmpty() && newComment.length() <= 10;
    }
 


}
