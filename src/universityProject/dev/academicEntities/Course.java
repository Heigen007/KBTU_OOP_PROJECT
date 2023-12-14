package universityProject.dev.academicEntities;

import java.util.Vector;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.users.Student;
import universityProject.dev.users.Teacher;

public class Course {

    private int courseID;
    private String courseName;
    private Vector<Integer> instructors;
    private Vector<Integer> students;
    private CourseType type;
    private int requiredYearOfStudy;
    private int credits;

    public Course() {
    }

    public Course(String courseName, CourseType type, int requiredYearOfStudy, int credits) {
        this.courseID = DataRepository.getNextId();
        this.courseName = courseName;
        this.instructors = new Vector<>();
        this.students = new Vector<>();
        this.type = type;
        this.requiredYearOfStudy = requiredYearOfStudy;
        this.credits = credits;
    }

    public int getCourseID() {
        return this.courseID;
    }

    public String getCourseName() {
        return this.courseName;
    }

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

    public void addInstructor(int instructor) {
        this.instructors.add(instructor);
    }

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

    public void addStudent(int student) {
        this.students.add(student);
    }

    public CourseType getType() {
        return this.type;
    }

    public int getRequiredYearOfStudy() {
        return this.requiredYearOfStudy;
    }

    public int getCredits() {
        return this.credits;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        return courseID == other.courseID;
    }
}