package universityProject;

public class Course {

    private int courseID;
    private String courseName;
    private Teacher instructors;
    private Student students;
    private CourseType type;
    private int requiredYearOfStudy;

    // Конструктор без параметров
    public Course() {
    }

    // Конструктор с параметрами
    public Course(int courseID, String courseName, Teacher instructors, Student students, CourseType type, int requiredYearOfStudy) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.instructors = instructors;
        this.students = students;
        this.type = type;
        this.requiredYearOfStudy = requiredYearOfStudy;
    }

    // Геттеры и сеттеры

    public int getCourseID() {
        return this.courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getInstructors() {
        return this.instructors;
    }

    public void setInstructors(Teacher instructors) {
        this.instructors = instructors;
    }

    public Student getStudents() {
        return this.students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }

    public CourseType getType() {
        return this.type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public int getRequiredYearOfStudy() {
        return this.requiredYearOfStudy;
    }

    public void setRequiredYearOfStudy(int requiredYearOfStudy) {
        this.requiredYearOfStudy = requiredYearOfStudy;
    }

    // Операции
    public void addInstructor(Supervisor newInstructor) {
        if (newInstructor != null) {
            this.instructors = newInstructor;
            System.out.println("Instructor added successfully to the course.");
        } else {
            System.out.println("Invalid instructor. Please provide a valid instructor to add.");
        }
    }
       public void addStudent(Teacher newStudent) {
        if (newStudent != null) {
            this.students = newStudent;
            System.out.println("Student added successfully to the course.");
        } else {
            System.out.println("Invalid student. Please provide a valid student to add.");
        }
    }

}
