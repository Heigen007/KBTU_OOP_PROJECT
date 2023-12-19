/**
 * The Manager class represents a manager in the university project system, extending
 * the functionality provided by the base Employee class.
 *
 * @version 1.0
 * @author Zhanibek
 */
package universityProject.dev.users;

import universityProject.dev.academicEntities.*;
import universityProject.dev.dataRepo.DataRepository;

import java.util.Vector;

public class Manager  extends Employee {
	/**
	 * The type of manager (e.g. OR, Department).
	 */
    private ManagerType managerType;
    /**
     * Default constructor for creating a Manager object.
     */
	public Manager() {
		super();
	}
	/**
     * Constructor for creating a Manager object with specified parameters.
     *
     * @param name        The name of the manager.
     * @param email       The email address of the manager.
     * @param password    The password for the manager.
     * @param managerType The type of manager.
     */
	public Manager(String name, String email, String password, ManagerType managerType) {
		super(name, email, password, false);
		this.managerType = managerType;
	}
	/**
     * Get the type of manager.
     *
     * @return The type of manager.
     */
    public ManagerType getManagerType() {
        return this.managerType;
    }
    /**
     * View information about student registrations for courses.
     */
    public void viewStudentRegistrations() {
        System.out.println("Registrations for courses:");
        System.out.println("-------------------------------");

        for (StudentRegistration registration : DataRepository.getStudentRegistrations()) {
            System.out.println("ID: " + registration.getRegistrationId());
            System.out.println("Student: " + registration.getStudent().getUserName());
            System.out.println("Course: " + registration.getCourse().getCourseName());
            System.out.println("------------------------------");
        }
    }
    /**
     * Approve a student registration for a course.
     *
     * @param registrationId The ID of the student registration to approve.
     */
	public void approveStudentRegistration(int registrationId) {
		StudentRegistration registration = DataRepository.getStudentRegistrationById(registrationId);

        if (registration != null) {
            DataRepository.removeStudentRegistration(registration);
            registration.getCourse().addStudent(registration.getStudent().getUserId());
            System.out.println("Registration approved.");
        } else {
            System.out.println("Registration with specified ID not found.");
        }
    }
	 /**
     * Create a new course with the specified parameters.
     *
     * @param courseName         The name of the new course.
     * @param type               The type of the new course.
     * @param requiredYearOfStudy The required year of study for the new course.
     * @param credits            The number of credits for the new course.
     */
    public void createCourse(String courseName, CourseType type, int requiredYearOfStudy, int credits) {
        if (courseName != null && !courseName.isEmpty()) {
            Course course = new Course(courseName, type, requiredYearOfStudy, credits);
            DataRepository.addCourse(course);
            System.out.println("Course created successfully.");
        } else {
            System.out.println("Course name cannot be empty.");
        }
    }
    /**
     * Assign a course to a teacher.
     *
     * @param course The course to assign.
     * @param teacher The teacher to assign the course to.
     */
    public void assignCourseToTeacher(Course course, Teacher teacher) {
        course.addInstructor(teacher);
        teacher.addCourse(course);
        System.out.println("Course assigned to teacher successfully.");
    }
    /**
     * View information about students.
     */
	public void viewInfoAboutStudents() {
        System.out.println("Information about students");
        System.out.println("-------------------------------");

        for (Student student : DataRepository.getStudents()) {
            System.out.println("ID: " + student.getUserId());
            System.out.println("Name: " + student.getUserName());
            System.out.println("Email: " + student.getUserEmail());
            System.out.println("------------------------------");
        }
    }
	/**
     * View information about teachers.
     */
	public void viewInfoAboutTeachers() {
        System.out.println("Information about teachers");
        System.out.println("-------------------------------");

        for (Teacher teacher : DataRepository.getTeachers()) {
            System.out.println("ID: " + teacher.getUserId());
            System.out.println("Name: " + teacher.getUserName());
            System.out.println("Email: " + teacher.getUserEmail());
            System.out.println("------------------------------");
        }
    }
	/**
     * Publish ordinary news with the specified title and content.
     *
     * @param title   The title of the news.
     * @param content The content of the news.
     */
    public void publishNews(String title, String content) {
        News news = new News(title, content, NewsTopic.ORDINARY);
        DataRepository.addNews(news);

        System.out.println("News published successfully.");
    }
    /**
     * Create a new student organization.
     */
    public void createStudentOrganization() {
        StudentOrganization organization = new StudentOrganization();
        DataRepository.addStudentOrganization(organization);

        System.out.println("Student organization created successfully.");
    }
    /** 
     * View information about complaints.
     */
    public void viewComplaints() {
        System.out.println("Complaints:");
        System.out.println("-------------------------------");

        for (Complaint complaint : DataRepository.getComplaints()) {
            System.out.println("ID: " + complaint.getComplaintId());
            System.out.println("Text: " + complaint.getComplaintText());
            System.out.println("Sender: " + complaint.getComplaintSender());
            System.out.println("Guilty: " + complaint.getComplaintGuilty());
            System.out.println("Urgency level: " + complaint.getUrgencyLevel());
            System.out.println("------------------------------");
        }
    }
    /**
     * Add a new journal to the system.
     */
    public void addJournal() {
        Journal journal = new Journal();
        DataRepository.addJournal(journal);
        System.out.println("Journal added successfully.");
    }
    /**
     * Publish news to a specific journal with the specified title and content.
     *
     * @param journal The journal to publish news to.
     * @param title   The title of the news.
     * @param content The content of the news.
     */
    public void publishNewsToJournal(Journal journal, String title, String content) {
        News news = new News(title, content, NewsTopic.JOURNAL);
        DataRepository.addNews(news);
        journal.addNews(news.getNewsId());
        System.out.println("News published successfully to journal.");
    }
    /**
     * Overrides the equals method of the base class to compare Manager objects.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
