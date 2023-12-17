package universityProject.dev.users;

import java.util.Vector;

import universityProject.dev.academicEntities.*;
import universityProject.dev.dataRepo.*;



public class Student extends User implements Observer {
    private Vector<Integer> enrolledCourses;
    private int credits;
    private Vector<Integer> marks;
    private Vector<Integer> studentOrganizations;
    private DegreeType degreeType;

    public Student() {
		super();
	}

	public Student(String name, String email, String password, Boolean isReseacher, DegreeType degreeType) {
		super(name, email, password, isReseacher);
        this.degreeType = degreeType;
        this.credits = 0;
        this.enrolledCourses = new Vector<Integer>();
        this.marks = new Vector<Integer>();
        this.studentOrganizations = new Vector<Integer>();
    }

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

    private int getCredits() {
        return this.credits;
    }

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

    public void rateTeacher(Teacher teacher, double mark){
        teacher.recieveMark(mark);
    }

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

    public DegreeType getDegreeType() {
        return this.degreeType;
    }

    public void subscribeToJournal(Journal journal) {
        journal.addSubscriber(this.getUserId());
    }

    public void applyForStudentOrganization(StudentOrganization studentOrganization) {
        studentOrganization.addMember(super.getUserId());
        this.studentOrganizations.add(studentOrganization.getOrganizationId());
    }
    
    @Override
    public void update(int newsItem) {
        System.out.println("Student " + super.getUserId() + " received news: " + newsItem);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
