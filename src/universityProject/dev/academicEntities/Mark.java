package universityProject.dev.academicEntities;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.users.Student;

public class Mark {

    private int markID;
    private int student;
    private int course;
    private int lesson;
    private int score;

    public Mark() {
    }

    public Mark(int student, int course, int lesson, int score) {
        if(isValidScore(score)) {
            this.markID = DataRepository.getNextId();
            this.student = student;
            this.course = course;
            this.lesson = lesson;
            this.score = score;
        } else {
            throw new IllegalArgumentException("Invalid score. Please provide a score within the valid range.");
        }
    }

    public int getMarkID() {
        return this.markID;
    }

    public Student getStudent() {
        return (Student) DataRepository.getUserById(this.student);
    }

    public Course getCourse() {
        return DataRepository.getCourseById(this.course);
    }

    public Lesson getLesson() {
        return DataRepository.getLessonById(this.lesson);
    }

    public int getScore() {
        return this.score;
    }

    private boolean isValidScore(int newScore) {
        return newScore >= 0 && newScore <= 100;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Mark other = (Mark) obj;
        return markID == other.markID;
    }
}