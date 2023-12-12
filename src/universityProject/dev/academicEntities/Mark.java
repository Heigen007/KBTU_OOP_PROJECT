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
        // Проверяем, что новая оценка находится в допустимом диапазоне (0-100, например)
        if (isValidScore(newScore)) {
            // Обновляем оценку
            this.score = newScore;
            System.out.println("Mark updated successfully.");
        } else {
            System.out.println("Invalid score. Please provide a score within the valid range.");
        }
    }

    // Пример метода для проверки допустимости оценки
    private boolean isValidScore(int newScore) {
        // В данном случае предполагается, что оценка должна быть в диапазоне от 0 до 100
        return newScore >= 0 && newScore <= 100;
    }

}
