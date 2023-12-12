package universityProject;

public class Lesson {

    private int lessonID;
    private int orderNumber;
    private Course course;
    private String topic;
    private LessonType type;

    // Конструктор без параметров
    public Lesson() {
    }

    // Конструктор с параметрами
    public Lesson(int lessonID, int orderNumber, Course course, String topic, LessonType type) {
        this.lessonID = lessonID;
        this.orderNumber = orderNumber;
        this.course = course;
        this.topic = topic;
        this.type = type;
    }

    // Геттеры и сеттеры

    public int getLessonID() {
        return this.lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LessonType getType() {
        return this.type;
    }

    public void setType(LessonType type) {
        this.type = type;
    }

    // Операции

}
