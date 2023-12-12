package universityProject.dev.users;

import universityProject.dev.academicEntities.*;

import universityProject.enums.TeacherTitle;

import java.util.ArrayList;

public class Teacher  extends Employee {

<<<<<<< HEAD
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
	
	
	
	
    
=======
    /**
     * ArrayList for cunducting rate, rate putted by Student(method - putRateToTeacher())
     */
    private ArrayList<Double> rates;
    private Course courses;
    private TeacherTitle title;

    private Course getCourses() {
        return this.courses;
    }

    private void setCourses(Course courses) {
        this.courses = courses;
    }

    private TeacherTitle getTitle() {
        return this.title;
    }

    private void setTitle(TeacherTitle title) {
        this.title = title;
    }

    public double getAverageRate(){
        if (this.rates.isEmpty()) {
            return 0; // Return null if the vector is empty
        }

        double total = 0;
        for (double mark : this.rates) {
            total += mark;
        }

        return total / this.rates.size();
    }
    public Course viewCourses() {
        //TODO
        return null;
    }


    public void addRate(double mark) {
        rates.add(mark);
    }
>>>>>>> d330f1dfd8dc97b9ccfa85b1aeb0f0e82d316718
}
