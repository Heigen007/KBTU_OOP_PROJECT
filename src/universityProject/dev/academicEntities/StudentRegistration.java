package universityProject.dev.academicEntities;

import java.io.Serializable;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.users.Student;

/**
 * @author Asyl
 * @version 18.12.2023
 * The StudentRegistration class represents the registration of a student for a specific course.
 * It contains information such as the registration ID, student ID, and course ID.
 */
public class StudentRegistration implements Serializable {

    /** The unique identifier for the registration. */
    private int registartionId;

    /** The ID of the student being registered. */
    private Integer student;

    /** The ID of the course for which the student is registered. */
    private Integer course;

    /** Default constructor for the StudentRegistration class. */
    public StudentRegistration() {
    }

    /**
     * Constructs a StudentRegistration object with specified parameters.
     *
     * @param student The ID of the student being registered.
     * @param course  The ID of the course for which the student is registered.
     */
    public StudentRegistration(Integer student, Integer course) {
        this.registartionId = DataRepository.getNextId();
        this.student = student;
        this.course = course;
    }

    /**
     * Retrieves the registration ID.
     *
     * @return The registration ID.
     */
    public int getRegistrationId() {
        return this.registartionId;
    }

    /**
     * Retrieves the student object associated with the registration.
     *
     * @return The student object associated with the registration.
     */
    public Student getStudent() {
        return DataRepository.getStudentById(this.student);
    }

    /**
     * Retrieves the course object associated with the registration.
     *
     * @return The course object associated with the registration.
     */
    public Course getCourse() {
        return DataRepository.getCourseById(this.course);
    }

    /**
     * Checks if two StudentRegistration objects are equal based on their registration ID.
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
        StudentRegistration other = (StudentRegistration) obj;
        return registartionId == other.registartionId;
    }

    /**
     * Generates a string representation of the StudentRegistration object.
     *
     * @return A string representation of the StudentRegistration object.
     */
    @Override
    public String toString() {
        return "StudentRegistration [registartionId=" + registartionId + ", student=" + student + ", course=" + course
                + "]";
    }
}
