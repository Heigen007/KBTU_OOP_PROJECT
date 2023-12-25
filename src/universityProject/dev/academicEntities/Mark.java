package universityProject.dev.academicEntities;

import java.io.Serializable;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.users.Student;

/**
 * @author Asyl
 * @version 18.12.2023
 * The Mark class represents a student's performance mark for a specific lesson in a course.
 * It contains information such as the mark ID, student, course, lesson, and the score.
 */
public class Mark implements Serializable {

    /** The unique identifier for the mark. */
    private int markID;

    /** The ID of the student who received the mark. */
    private int student;

    /** The ID of the course associated with the mark. */
    private int course;

    /** The ID of the lesson for which the mark is assigned. */
    private int lesson;

    /** The numerical score received by the student. */
    private int score;

    /** Default constructor for the Mark class. */
    public Mark() {
    }

    /**
     * Constructs a Mark object with specified parameters.
     *
     * @param student The ID of the student who received the mark.
     * @param course  The ID of the course associated with the mark.
     * @param lesson  The ID of the lesson for which the mark is assigned.
     * @param score   The numerical score received by the student.
     * @throws IllegalArgumentException if the provided score is outside the valid range (0-100).
     */
    public Mark(int student, int course, int lesson, int score) {
        if (isValidScore(score)) {
            this.markID = DataRepository.getNextId();
            this.student = student;
            this.course = course;
            this.lesson = lesson;
            this.score = score;
        } else {
            throw new IllegalArgumentException("Invalid score. Please provide a score within the valid range.");
        }
    }

    /**
     * Retrieves the mark ID.
     *
     * @return The mark ID.
     */
    public int getMarkID() {
        return this.markID;
    }

    /**
     * Retrieves the student who received the mark.
     *
     * @return The student who received the mark.
     */
    public Student getStudent() {
        return (Student) DataRepository.getUserById(this.student);
    }

    /**
     * Retrieves the course associated with the mark.
     *
     * @return The course associated with the mark.
     */
    public Course getCourse() {
        return DataRepository.getCourseById(this.course);
    }

    /**
     * Retrieves the lesson for which the mark is assigned.
     *
     * @return The lesson for which the mark is assigned.
     */
    public Lesson getLesson() {
        return DataRepository.getLessonById(this.lesson);
    }

    /**
     * Retrieves the numerical score received by the student.
     *
     * @return The numerical score received by the student.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Checks if a provided score is within the valid range (0-100).
     *
     * @param newScore The score to be validated.
     * @return True if the score is valid, false otherwise.
     */
    private boolean isValidScore(int newScore) {
        return newScore >= 0 && newScore <= 100;
    }

    /**
     * Checks if two Mark objects are equal based on their mark ID.
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
        Mark other = (Mark) obj;
        return markID == other.markID;
    }

    /**
     * Generates a string representation of the Mark object.
     *
     * @return A string representation of the Mark object.
     */
    @Override
    public String toString() {
        return "Mark [markID=" + markID + ", student=" + student + ", course=" + course + ", lesson=" + lesson
                + ", score=" + score + "]";
    }
}
