/**
 * The Student class represents a student in the university project system, extending
 * the functionality provided by the base User class and implementing the Observer interface.
 *
 * @version 1.0
 * @author Zhanibek
 */
package universityProject.dev.users;

import java.util.Vector;

import universityProject.dev.academicEntities.*;
import universityProject.dev.dataRepo.*;



public class Student extends User implements Observer {
	/**
     * A vector containing the IDs of courses the student is currently enrolled in.
     */
    private Vector<Integer> enrolledCourses;
    /**
     * The total credits earned by the student.
     */
    private int credits;
    /**
     * A vector containing the IDs of marks received by the student.
     */
    private Vector<Integer> marks;
    /**
     * A vector containing the IDs of student organizations the student is a member of.
     */
    private Vector<Integer> studentOrganizations;
    /**
     * The type of degree the student is pursuing.
     */
    private DegreeType degreeType;
    /**
     * Default constructor for creating a Student object.
     */
    public Student() {
		super();
	}
    /**
     * Constructor for creating a Student object with specified parameters.
     * 
     * @param name        The name of the student.
     * @param email       The email address of the student.
     * @param password    The password for the student.
     * @param isResearcher A boolean indicating whether the student is a researcher.
     * @param degreeType  The type of degree the student is pursuing.
     */
	public Student(String name, String email, String password, Boolean isReseacher, DegreeType degreeType) {
		super(name, email, password, isReseacher);
        this.degreeType = degreeType;
        this.credits = 0;
        this.enrolledCourses = new Vector<Integer>();
        this.marks = new Vector<Integer>();
        this.studentOrganizations = new Vector<Integer>();
    }
	/**
     * Get a list of courses the student is currently enrolled in.
     *
     * @return Vector of enrolled courses.
     */
    private Vector<Course> getEnrolledCourses() {
        Vector<Course> courses = new Vector<>();
        for (Integer courseId : this.enrolledCourses) {
            Course course = DataRepository.getCourseById(courseId);
            if (course != null) {
                courses.add(course);
            }
        }
        return courses;
    }
    /**
     * Get the total credits earned by the student.
     *
     * @return The total credits earned.
     */
    private int getCredits() {
        return this.credits;
    }
    /**
     * Print the student's transcript, displaying information about their marks.
     */
    public void viewTranscript() {
        System.out.println("Transcript for " + super.getUserName());
        System.out.println("-------------------------------");

        // Печатаем информацию об оценках
        for (Mark mark : DataRepository.getMarks()) {
        	if(mark.getStudent().equals(this)) {
                System.out.println("Course: " + mark.getCourse());
                System.out.println("Lesson: " + mark.getLesson());
                System.out.println("Score: " + mark.getScore());
            }
        }
    }
    /**
     * Print a list of courses the student is currently enrolled in.
     */
    public void viewCourses() {
        System.out.println("Enrolled Courses for " + super.getUserName());
        if(DataRepository.getCourses().size() > 0) {
        	for(Course course : DataRepository.getCourses()) {
        		if(course.getStudents().contains(this)) {
        			System.out.println(course.getCourseName());
        		}
        	}
        }
        else {
        	System.out.println("No enrolled courses");
        }
    }
    /**
     * Print a list of marks for the student.
     */
    public void viewMarks() {
    	System.out.println("Marks for " + this.getUserName());
    	if(DataRepository.getMarks() != null) {
    		for(Mark mark : DataRepository.getMarks()) {
    			if(mark.getStudent().getUserName().equals(this.getUserName())){
    				System.out.println(mark.getScore());
    			}
    		}
    	}
    }
    /**
     * Register the student for a specified course.
     *
     * @param course The course to register for.
     */
    public void registerForCourse(Course course) {
        if(course.getStudents().contains(this)) {
            System.out.println("You are already enrolled in this course");
        }
        else {
            StudentRegistration studentRegistration = new StudentRegistration(this.getUserId(), course.getCourseID());
            DataRepository.addStudentRegistration(studentRegistration);
            System.out.println("You have successfully registered for the course " + course.getCourseName());
        }                               
    }
    /**
     * Rate a teacher based on the student's evaluation.
     *
     * @param teacher The teacher to rate.
     * @param mark    The mark to assign to the teacher.
     */
    public void rateTeacher(Teacher teacher, double mark){
        teacher.recieveMark(mark);
    }
    /**
     * Get a list of student organizations the student is a member of.
     *
     * @return Vector of student organizations.
     */
    public Vector<StudentOrganization> getStudentOrganizations() {
        Vector<StudentOrganization> studentOrganizations = new Vector<>();
        for (Integer studentOrganizationId : this.studentOrganizations) {
            StudentOrganization studentOrganization = DataRepository.getStudentOrganizationById(studentOrganizationId);
            if (studentOrganization != null) {
                studentOrganizations.add(studentOrganization);
            }
        }
        return studentOrganizations;
    }
    /**
     * Get the degree type of the student.
     *
     * @return The degree type.
     */
    public DegreeType getDegreeType() {
        return this.degreeType;
    }
    /**
     * Subscribe the student to a journal for updates.
     *
     * @param journal The journal to subscribe to.
     */
    public void subscribeToJournal(Journal journal) {
        journal.addSubscriber(this.getUserId());
    }
    /**
     * Apply for membership in a student organization.
     *
     * @param studentOrganization The student organization to apply to.
     */
    public void applyForStudentOrganization(StudentOrganization studentOrganization) {
        studentOrganization.addMember(super.getUserId());
        this.studentOrganizations.add(studentOrganization.getOrganizationId());
    }
    /**
     * Update method from the Observer interface. Receives news updates.
     *
     * @param newsItem The news item to receive.
     */
    @Override
    public void update(int newsItem) {
        System.out.println("Student " + super.getUserId() + " received news: " + newsItem);
    }
    /**
     * Overrides the equals method of the base class to compare Student objects.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
