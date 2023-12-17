package universityProject.dev.users;

import universityProject.dev.academicEntities.*;
import universityProject.dev.dataRepo.DataRepository;

import java.util.Vector;

public class Manager  extends Employee {
    private ManagerType managerType;
    
	public Manager() {
		super();
	}

	public Manager(String name, String email, String password, ManagerType managerType) {
		super(name, email, password, false);
		this.managerType = managerType;
	}

    public ManagerType getManagerType() {
        return this.managerType;
    }

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

    public void createCourse(String courseName, CourseType type, int requiredYearOfStudy, int credits) {
        if (courseName != null && !courseName.isEmpty()) {
            Course course = new Course(courseName, type, requiredYearOfStudy, credits);
            DataRepository.addCourse(course);
            System.out.println("Course created successfully.");
        } else {
            System.out.println("Course name cannot be empty.");
        }
    }

    public void assignCourseToTeacher(Course course, Teacher teacher) {
        course.addInstructor(teacher);
        teacher.addCourse(course);
        System.out.println("Course assigned to teacher successfully.");
    }
    
	public void viewInfoAboutStudents() {
        System.out.println("Information about students");
        System.out.println("-------------------------------");

        for (Student student : DataRepository.getStudents()) {
            System.out.println("ID: " + student.getUserId());
            System.out.println("Имя: " + student.getUserName());
            System.out.println("Email: " + student.getUserEmail());
            System.out.println("------------------------------");
        }
    }
    
	public void viewInfoAboutTeachers() {
        System.out.println("Information about teachers");
        System.out.println("-------------------------------");

        for (Teacher teacher : DataRepository.getTeachers()) {
            System.out.println("ID: " + teacher.getUserId());
            System.out.println("Имя: " + teacher.getUserName());
            System.out.println("Email: " + teacher.getUserEmail());
            System.out.println("------------------------------");
        }
    }
	
    public void publishNews(String title, String content) {
        News news = new News(title, content, NewsTopic.ORDINARY);
        DataRepository.addNews(news);

        System.out.println("News published successfully.");
    }
    
    public void createStudentOrganization() {
        StudentOrganization organization = new StudentOrganization();
        DataRepository.addStudentOrganization(organization);

        System.out.println("Student organization created successfully.");
    }

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

    public void addJournal() {
        Journal journal = new Journal();
        DataRepository.addJournal(journal);
        System.out.println("Journal added successfully.");
    }

    public void publishNewsToJournal(Journal journal, String title, String content) {
        News news = new News(title, content, NewsTopic.JOURNAL);
        DataRepository.addNews(news);
        journal.addNews(news.getNewsId());
        System.out.println("News published successfully to journal.");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
