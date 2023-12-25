package universityProject.dev.academicEntities;

import java.io.Serializable;

import universityProject.dev.dataRepo.DataRepository;

/**
 * @author Asyl
 * @version 18.12.2023
 * The Lesson class represents an academic lesson within the university.
 * It contains information such as the lesson ID, associated course, topic, and type.
 */
public class Lesson implements Serializable {

    /** The unique identifier for the lesson. */
    private int lessonID;

    /** The ID of the course associated with the lesson. */
    private int course;

    /** The topic of the lesson. */
    private String topic;

    /** The type of the lesson (e.g., lecture, lab). */
    private LessonType type;

    /** Default constructor for the Lesson class. */
    public Lesson() {
    }

    /**
     * Constructs a Lesson object with specified parameters.
     *
     * @param course The ID of the course associated with the lesson.
     * @param topic  The topic of the lesson.
     * @param type   The type of the lesson (e.g., lecture, lab).
     */
    public Lesson(int course, String topic, LessonType type) {
        this.lessonID = DataRepository.getNextId();
        this.course = course;
        this.topic = topic;
        this.type = type;
    }

    /**
     * Retrieves the lesson ID.
     *
     * @return The lesson ID.
     */
    public int getLessonID() {
        return this.lessonID;
    }

    /**
     * Retrieves the course associated with the lesson.
     *
     * @return The course associated with the lesson.
     */
    public Course getCourse() {
        return DataRepository.getCourseById(this.course);
    }

    public Integer getCourseID() {
        return this.course;
    }

    /**
     * Retrieves the topic of the lesson.
     *
     * @return The topic of the lesson.
     */
    public String getTopic() {
        return this.topic;
    }

    /**
     * Retrieves the type of the lesson.
     *
     * @return The type of the lesson.
     */
    public LessonType getType() {
        return this.type;
    }

    /**
     * Checks if two Lesson objects are equal based on their lesson ID.
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
        Lesson other = (Lesson) obj;
        return lessonID == other.lessonID;
    }

    /**
     * Generates a string representation of the Lesson object.
     *
     * @return A string representation of the Lesson object.
     */
    @Override
    public String toString() {
        return "Lesson [lessonID=" + lessonID + ", course=" + course + ", topic=" + topic + ", type=" + type + "]";
    }
}
