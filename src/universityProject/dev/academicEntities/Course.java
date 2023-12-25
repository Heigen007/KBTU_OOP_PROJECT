package universityProject.dev.academicEntities;

import java.io.Serializable;
import java.util.Vector;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.users.Student;
import universityProject.dev.users.Teacher;
/**
 * @author Asyl
 * @version 18.12.2023
 * The Course class represents an academic course within the university.
 * It contains information such as the course ID, name, instructors, students, type, required year of study, and credits.
 */
public class Course implements Serializable {

    /** The unique identifier for the course. */
    private int courseID;

    /** The name of the course. */
    private String courseName;

    /** The IDs of the instructors teaching the course. */
    private Vector<Integer> instructors;

    /** The IDs of the students enrolled in the course. */
    private Vector<Integer> students;

    /** The type of the course (e.g., lecture, lab). */
    private CourseType type;

    /** The required year of study for the course. */
    private int requiredYearOfStudy;

    /** The number of credits assigned to the course. */
    private int credits;

    /** Default constructor for the Course class. */
    public Course() {
    }

    /**
     * Constructs a Course object with specified parameters.
     *
     * @param courseName           The name of the course.
     * @param type                 The type of the course (e.g., lecture, lab).
     * @param requiredYearOfStudy  The required year of study for the course.
     * @param credits              The number of credits assigned to the course.
     */
    public Course(String courseName, CourseType type, int requiredYearOfStudy, int credits) {
        this.courseID = DataRepository.getNextId();
        this.courseName = courseName;
        this.instructors = new Vector<>();
        this.students = new Vector<>();
        this.type = type;
        this.requiredYearOfStudy = requiredYearOfStudy;
        this.credits = credits;
    }

    /**
     * Retrieves the course ID.
     *
     * @return The course ID.
     */
    public int getCourseID() {
        return this.courseID;
    }

    /**
     * Retrieves the name of the course.
     *
     * @return The name of the course.
     */
    public String getCourseName() {
        return this.courseName;
    }

    /**
     * Retrieves the instructors teaching the course.
     *
     * @return A vector containing the instructors teaching the course.
     */
    public Vector<Teacher> getInstructors() {
        Vector<Teacher> teachers = new Vector<>();
        for (Integer instructorId : this.instructors) {
            Teacher teacher = DataRepository.getTeacherById(instructorId);
            if (teacher != null) {
                teachers.add(teacher);
            }
        }
        return teachers;
    }

    /**
     * Adds an instructor to the course.
     *
     * @param instructor The instructor to be added to the course.
     */
    public void addInstructor(Teacher instructor) {
        this.instructors.add(instructor.getUserId());
    }

    /**
     * Retrieves the students enrolled in the course.
     *
     * @return A vector containing the students enrolled in the course.
     */
    public Vector<Student> getStudents() {
        Vector<Student> studentsTmp = new Vector<>();
        for (Integer studentId : this.students) {
            Student student = DataRepository.getStudentById(studentId);
            if (student != null) {
                studentsTmp.add(student);
            }
        }
        return studentsTmp;
    }

    /**
     * Adds a student to the course.
     *
     * @param student The ID of the student to be added to the course.
     */
    public void addStudent(int student) {
        this.students.add(student);
    }

    /**
     * Retrieves the type of the course.
     *
     * @return The type of the course.
     */
    public CourseType getType() {
        return this.type;
    }

    /**
     * Retrieves the required year of study for the course.
     *
     * @return The required year of study for the course.
     */
    public int getRequiredYearOfStudy() {
        return this.requiredYearOfStudy;
    }

    /**
     * Retrieves the number of credits assigned to the course.
     *
     * @return The number of credits assigned to the course.
     */
    public int getCredits() {
        return this.credits;
    }

    /**
     * Checks if two Course objects are equal based on their course ID.
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
        Course other = (Course) obj;
        return courseID == other.courseID;
    }

    /**
     * Generates a string representation of the Course object.
     *
     * @return A string representation of the Course object.
     */
    @Override
    public String toString() {
        return "Course [courseID=" + courseID + ", courseName=" + courseName + ", instructors=" + instructors
                + ", students=" + students + ", type=" + type + ", requiredYearOfStudy=" + requiredYearOfStudy
                + ", credits=" + credits + "]";
    }
}
