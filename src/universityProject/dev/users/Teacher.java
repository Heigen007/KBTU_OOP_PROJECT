package universityProject.dev.users;

import universityProject.dev.academicEntities.*;

/**
* @generated
*/
public class Teacher  extends Employee {
    
    /**
    * @generated
    */
    private Course courses;
    
    /**
    * @generated
    */
    private TeacherTitle title;
    
    
    

    public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(Integer userId, String name, String email, String password, Boolean isReseacher, Course courses, TeacherTitle title) {
		super(userId, name, email, password, isReseacher);
		// TODO Auto-generated constructor stub
		this.courses = courses;
		this.title = title;
	}

	public TeacherTitle getTitle() {
		return this.title;
	}
    
	public Course viewCourses() {
		return this.courses;
	}
	
	public void sendComplaintToDean(String text, UrgencyLevel urgencyLevel) {
		
	}
	
	public void putMark(Student student, Course course, Lesson lesson, int score) {
		Mark mark = new Mark(student, course, lesson, score);
		
		mark.updateMark(score);
	}
	
	
	public void addLesson() {
		
	}
	
	
	
	
    
}
