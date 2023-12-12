package universityProject.dev.users;

import universityProject.dev.academicEntities.*;
import universityProject.dev.dataRepo.*;

import java.util.ArrayList;

/**
* @generated
*/
public class Student extends User implements Observer {
    private Course enrolledCourses;
    private int credits;
    private Mark marks;
    private StudentOrganization studentOrganizations;

    public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer userId, String name, String email, String password, Boolean isReseacher, Course enrolledCourse, int credits, Mark marks, StudentOrganization studentOrganizations) {
		super(userId, name, email, password, isReseacher);
		// TODO Auto-generated constructor stub
		this.credits = credits;
		this.enrolledCourses = enrolledCourse;
		this.marks = marks;
		this.studentOrganizations = studentOrganizations;
	}

	/**
    * @generated
    */
    private Course getEnrolledCourses() {
        return this.enrolledCourses;
    }
    


    private void setEnrolledCourses(Course enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    private int getCredits() {
        return this.credits;
    }

    private void setCredits(Integer credits) {
        this.credits = credits;
    }

    private Mark getMarks() {
        return this.marks;
    }

    private void setMarks(Mark marks) {
        this.marks = marks;
    }

    private StudentOrganization getStudentOrganizations() {
        return this.studentOrganizations;
    }
    
    /**
    * @generated
    */
    private void setStudentOrganizations(StudentOrganization studentOrganizations) {
        this.studentOrganizations = studentOrganizations;
    }
    
    public String getDegreeType() {
        //TODO
        return "";
    }
    
    

    //                          Operations                                  




    public void viewTranscript() {
        System.out.println("Transcript for " + getName());
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
        System.out.println("Enrolled Courses for " + getName());
        if(DataRepository.getCourses() != null) {
        	for(Course course : DataRepository.getCourses()) {
        		if(course.getStudents().getName().equals(this.getName())) {
        			System.out.println(course.getCourseName());
        		}
        	}
        }
        else {
        	System.out.println("No enrolled courses");
        }
    }
    
    public void viewMarks() {
    	System.out.println("Marks for " + this.getName());
    	if(DataRepository.getMarks() != null) {
    		for(Mark mark : DataRepository.getMarks()) {
    			if(mark.getStudent().getName().equals(this.getName())){
    				System.out.println(mark.getScore());
    			}
    		}
    	}
    }
    
    public void registerForCourse(Course course, Manager manager) {
        if (course != null && manager != null) {
            // Проверяем, не записан ли студент уже на этот курс
            if (DataRepository.getCourses().contains(course)) {
                System.out.println("Вы уже записаны на этот курс.");
            } else {
                // Добавляем курс в список записанных курсов
//                DataRepository.addCourse(course);
                System.out.println("Регистрация на курс " + course.getCourseName() + " отправлена на подтверждение.");
                // Передаем запрос на подтверждение регистрации менеджеру
                manager.approveStudentRegistration(this, course);
            }
        } else {
            System.out.println("Неверно указан курс или менеджер для регистрации.");
        }
    }
    


    public String getDegreeType() {
        //TODO
        return "";
    }

    public boolean isEligibleForCourse() {
        //TODO
        return false;
    }

    public void putRateToTeacher(int teachersId, double mark){
        for (Teacher teacher: universityProject.dev.dataRepo.DataRepository.getTeachers()){
            if(teacher.getUserID()==teachersId){
                teacher.addRate(mark);
            }
        }
    }

    @Override
    public void update(int newsItem) {
        System.out.println("Student " + getUserID() + " received news: " + newsItem);
    }
    
    
}
