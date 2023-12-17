package universityProject.dev.users;

import universityProject.dev.academicEntities.*;
import universityProject.dev.dataRepo.DataRepository;

import java.util.Vector;

public class Teacher extends Employee {

    private Vector<Integer> courses;
    private TeacherTitle title;
    private Vector<Double> rates;

    public Teacher() {
		super();
	}

	public Teacher(String name, String email, String password, Boolean isReseacher, TeacherTitle title) {
		super(name, email, password, isReseacher);
        this.title = title;
        this.courses = new Vector<Integer>();
        this.rates = new Vector<Double>();
	}

	public TeacherTitle getTitle() {
		return this.title;
	}

    public void addCourse(Course course) {
        this.courses.add(course.getCourseID());
    }
    
	public void viewCourses() {
        System.out.println("Courses for " + getUserName());
        System.out.println("-------------------------------");
        for (Integer courseId : this.courses) {
            Course course = DataRepository.getCourseById(courseId);
            if (course != null) {
                System.out.println(course);
            }
        }
	}
	
	public void sendComplaintToDean(String text, UrgencyLevel urgencyLevel, Student student) {
        Complaint complaint = new Complaint(text, urgencyLevel, getUserId(), student.getUserId());
        DataRepository.addComplaint(complaint);
	}
	
	public void putMark(Student student, Course course, Lesson lesson, int score) {
		Mark mark = new Mark(student.getUserId(), course.getCourseID(), lesson.getLessonID(), score);
		DataRepository.addMark(mark);
	}

	public void addLesson(Course course, String topic, LessonType type) {
        Lesson lesson = new Lesson(course.getCourseID(), topic, type);
        DataRepository.addLesson(lesson);
    }

    public void recieveMark(Double mark) {
        this.rates.add(mark);
    }

    public Double getAverageMark() {
        Double sum = 0.0;
        for (Double rate : this.rates) {
            sum += rate;
        }
        return sum / this.rates.size();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
