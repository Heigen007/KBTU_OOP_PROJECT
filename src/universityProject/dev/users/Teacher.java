/**
 * The Teacher class represents a teacher in the university project system, extending
 * the functionality provided by the base Employee class.
 *
 * @version 1.0
 * @author Zhanibek
 */
package universityProject.dev.users;

import universityProject.Employee;
import universityProject.dev.academicEntities.*;
import universityProject.dev.dataRepo.DataRepository;
import universityProject.enums.TeacherTitle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class Teacher extends Employee {
	/**
     * A vector containing the IDs of courses taught by the teacher.
     */
    private Vector<Integer> courses;
    /**
     * The title of the teacher 
     */
    private TeacherTitle title;
    /**
     * A vector containing the rates or evaluations received by the teacher.
     */
    private Vector<Double> rates;
    /**
     * Default constructor for creating a Teacher object.
     */


    public Teacher() {
		super();
	}
    /**
     * Constructor for creating a Teacher object with specified parameters.
     *
     * @param name        The name of the teacher.
     * @param email       The email address of the teacher.
     * @param password    The password for the teacher.
     * @param isResearcher A boolean indicating whether the teacher is a researcher.
     * @param title       The title of the teacher.
     */
	public Teacher(String name, String email, String password, Boolean isReseacher, TeacherTitle title) {
		super(name, email, password, isReseacher);
        this.title = title;
        this.courses = new Vector<Integer>();
        this.rates = new Vector<Double>();
        createLogRecord("Teacher has been created");
	}
	/**
     * Get the title of the teacher.
     *
     * @return The title of the teacher.
     */
	public TeacherTitle getTitle() {
		return this.title;
	}
    /**
     * Add a course to the list of courses taught by the teacher.
     *
     * @param course The course to add.
     */
    public void addCourse(universityProject.dev.academicEntities.Course course) {
        this.courses.add(course.getCourseID());
        createLogRecord("Teacher added course");
    }
    /**
     * Print a list of courses taught by the teacher.
     */
	public void viewCourses() {
        System.out.println("Courses for " + getUserName());
        System.out.println("-------------------------------");
        for (Integer courseId : this.courses) {
            Course course = DataRepository.getCourseById(courseId);
            if (course != null) {
                System.out.println(course);
            }
        }
        createLogRecord("Teacher viewed courses");
	}
	/**
     * Send a complaint to the dean about a student.
     *
     * @param text         The text of the complaint.
     * @param urgencyLevel The urgency level of the complaint.
     * @param student      The student being complained about.
     */
	public void sendComplaintToDean(String text, universityProject.dev.academicEntities.UrgencyLevel urgencyLevel, universityProject.dev.users.Student student) {
        universityProject.dev.academicEntities.Complaint complaint = new universityProject.dev.academicEntities.Complaint(text, urgencyLevel, getUserId(), student.getUserId());
        DataRepository.addComplaint(complaint);
        createLogRecord("Teacher send complaint to dean");
	}
	/**
     * Put a mark for a student in a specific course and lesson.
     *
     * @param student The student to put the mark for.
     * @param course  The course for which the mark is assigned.
     * @param lesson  The lesson for which the mark is assigned.
     * @param score   The score to assign to the student.
     */
	public void putMark(Student student, Course course, Lesson lesson, int score) {
		Mark mark = new Mark(student.getUserId(), course.getCourseID(), lesson.getLessonID(), score);
		DataRepository.addMark(mark);
        createLogRecord("Teacher putted mark");
	}
	/**
     * Add a new lesson to a specific course taught by the teacher.
     *
     * @param course The course for which the lesson is added.
     * @param topic  The topic or subject of the lesson.
     * @param type   The type of lesson (e.g., Lecture, Lab).
     */
	public void addLesson(Course course, String topic, LessonType type) {
        Lesson lesson = new Lesson(course.getCourseID(), topic, type);
        DataRepository.addLesson(lesson);
        createLogRecord("Teacher added lesson");
    }
	/**
     * Receive a mark or evaluation from a student.
     *
     * @param mark The mark received from a student.
     */
    public void recieveMark(Double mark) {
        this.rates.add(mark);

    }
    /**
     * Calculate and get the average mark received by the teacher.
     *
     * @return The average mark received by the teacher.
     */
    public Double getAverageMark() {
        Double sum = 0.0;
        for (Double rate : this.rates) {
            sum += rate;
        }
        return sum / this.rates.size();
    }


    public void createLogRecord(String text){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        universityProject.dev.logs.LogRecord logRecord = new universityProject.dev.logs.LogRecord(this.getUserId(), formattedDateTime, text);
        universityProject.dev.logs.LogsSettings.addLogRecord(logRecord);
    }


    /**
     * Overrides the equals method of the base class to compare Teacher objects.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
