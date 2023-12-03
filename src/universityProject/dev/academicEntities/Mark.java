package universityProject;

public class Mark {

    private int markID;
    private Student student;
    private Course course;
    private Lesson lesson;
    private int score;

    // Конструктор без параметров
    public Mark() {
    }

    // Конструктор с параметрами
    public Mark(int markID, Student student, Course course, Lesson lesson, int score) {
        this.markID = markID;
        this.student = student;
        this.course = course;
        this.lesson = lesson;
        this.score = score;
    }

    // Геттеры и сеттеры

    public int getMarkID() {
        return this.markID;
    }

    public void setMarkID(int markID) {
        this.markID = markID;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Lesson getLesson() {
        return this.lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Операции
public void updateMark(int newScore) {
        this.score = newScore;
    }

}
