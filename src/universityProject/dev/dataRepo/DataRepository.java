package universityProject.dev.dataRepo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import universityProject.dev.users.*;
import universityProject.dev.academicEntities.*;
import universityProject.dev.research.*;

public class DataRepository {
    private static Vector<Student> students;
    private static Vector<Teacher> teachers;
    private static Vector<Admin> admins;
    private static Vector<Manager> managers;
    private static Vector<TechSupportSpecialist> techSupportSpecialists;
    private static Vector<ResearcherDecorator> researchers;
    private static Vector<Course> courses;
    private static Vector<Lesson> lessons;
    private static Vector<Mark> marks;
    private static Vector<Message> messages;
    private static Vector<Complaint> complaints;
    private static Vector<Order> orders;
    private static Vector<StudentOrganization> studentOrganizations;
    private static Vector<ResearchPaper> researchPapers;
    private static Vector<ResearchProject> researchProjects;
	private static Vector<News> neews;
	private static Vector<abcd> abcds;

    static {
        students = new Vector<Student>();
        teachers = new Vector<Teacher>();
        admins = new Vector<Admin>();
        managers = new Vector<Manager>();
        techSupportSpecialists = new Vector<TechSupportSpecialist>();
        researchers = new Vector<ResearcherDecorator>();
        courses = new Vector<Course>();
        lessons = new Vector<Lesson>();
        marks = new Vector<Mark>();
        neews = new Vector<News>();
        messages = new Vector<Message>();
        complaints = new Vector<Complaint>();
        orders = new Vector<Order>();
        studentOrganizations = new Vector<StudentOrganization>();
        researchPapers = new Vector<ResearchPaper>();
        researchProjects = new Vector<ResearchProject>();
        abcds = new Vector<abcd>();
    }
    // constructor
    public DataRepository() {}

    /**
     * Pulls data from the database and populates the static vectors in the DataRepository.
     * This method deserializes data from corresponding files and loads it into the application's memory.
     * It is typically used to initialize or refresh the application's data state from persistent storage.
     */
    @SuppressWarnings("unchecked")
	public static void pullDataFromDatabase() {
        try {
            students = (Vector<Student>) deserialize("data/students.dat");
            abcds = (Vector<abcd>) deserialize("data/abcds.dat");
            teachers = (Vector<Teacher>) deserialize("data/teachers.dat");
            admins = (Vector<Admin>) deserialize("data/admins.dat");
            managers = (Vector<Manager>) deserialize("data/managers.dat");
            techSupportSpecialists = (Vector<TechSupportSpecialist>) deserialize("data/techSupportSpecialists.dat");
            researchers = (Vector<ResearcherDecorator>) deserialize("data/researchers.dat");
            courses = (Vector<Course>) deserialize("data/courses.dat");
            lessons = (Vector<Lesson>) deserialize("data/lessons.dat");
            marks = (Vector<Mark>) deserialize("data/marks.dat");
            neews = (Vector<News>) deserialize("data/news.dat");
            messages = (Vector<Message>) deserialize("data/messages.dat");
            complaints = (Vector<Complaint>) deserialize("data/complaints.dat");
            orders = (Vector<Order>) deserialize("data/orders.dat");
            studentOrganizations = (Vector<StudentOrganization>) deserialize("data/studentOrganizations.dat");
            researchPapers = (Vector<ResearchPaper>) deserialize("data/researchPapers.dat");
            researchProjects = (Vector<ResearchProject>) deserialize("data/researchProjects.dat");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return ois.readObject();
        }
    }

    /**
     * Saves transaction data to the database. This method serializes the current state of the static arrays
     * in the DataRepository and writes them to corresponding files for persistent storage.
     * It is typically used for saving the current state of the application data such as students, teachers,
     * courses, etc., to ensure data consistency and durability.
     */
    public static void saveTransactionDataToDB() {
        try {
        	serialize(abcds, "data/abcds.dat");
            serialize(students, "data/students.dat");
            serialize(teachers, "data/teachers.dat");
            serialize(admins, "data/admins.dat");
            serialize(managers, "data/managers.dat");
            serialize(techSupportSpecialists, "data/techSupportSpecialists.dat");
            serialize(researchers, "data/researchers.dat");
            serialize(courses, "data/courses.dat");
            serialize(lessons, "data/lessons.dat");
            serialize(marks, "data/marks.dat");
            serialize(neews, "data/news.dat");
            serialize(messages, "data/messages.dat");
            serialize(complaints, "data/complaints.dat");
            serialize(orders, "data/orders.dat");
            serialize(studentOrganizations, "data/studentOrganizations.dat");
            serialize(researchPapers, "data/researchPapers.dat");
            serialize(researchProjects, "data/researchProjects.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void serialize(Object obj, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
        }
    }

    /**
     * Retrieves the current user of the application. This method searches for a user by their ID
     * in the various vectors like Student, Teacher, Admin, Manager, TechSupportSpecialist.
     * It is useful for identifying the current user based on their unique identifier and obtaining
     * their specific data and permissions.
     *
     * @return User the current user of the application, or null if the user is not found.
     */
    public static User getCurrentUser(String userName, String password) {
        // create a vector of vectors we will iterate through
        Vector<Vector<? extends User>> vectors = new Vector<>();
        vectors.add(students);
        vectors.add(teachers);
        vectors.add(admins);
        vectors.add(managers);
        vectors.add(techSupportSpecialists);

        // iterate through the vectors and search for the user
//        for (Vector<? extends User> vector : vectors) {
//            for (User user : vector) {
//                if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
//                    return user;
//                }
//            }
//        }
        return null;
    }


    // get methods
    public static Vector<Student> getStudents() {
        return students;
    }
    public static Vector<Teacher> getTeachers() {
        return teachers;
    }
    public static Vector<Admin> getAdmins() {
        return admins;
    }
    public static Vector<Manager> getManagers() {
        return managers;
    }
    public static Vector<TechSupportSpecialist> getTechSupportSpecialists() {
        return techSupportSpecialists;
    }
    public static Vector<ResearcherDecorator> getResearchers() {
        return researchers;
    }
    public static Vector<Course> getCourses() {
        return courses;
    }
    public static Vector<Lesson> getLessons() {
        return lessons;
    }
    public static Vector<Mark> getMarks() {
        return marks;
    }
    public static Vector<News> getNews() {
        return neews;
    }
    public static Vector<Message> getMessages() {
        return messages;
    }
    public static Vector<Complaint> getComplaints() {
        return complaints;
    }
    public static Vector<Order> getOrders() {
        return orders;
    }
    public static Vector<StudentOrganization> getStudentOrganizations() {
        return studentOrganizations;
    }
    public static Vector<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }
    public static Vector<ResearchProject> getResearchProjects() {
        return researchProjects;
    }
    public static Vector<abcd> getabcds() {
        return abcds;
    }


    // add methods
    public static void addStudent(Student student) {
        students.add(student);
    }
    public static void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    public static void addAdmin(Admin admin) {
        admins.add(admin);
    }
    public static void addManager(Manager manager) {
        managers.add(manager);
    }
    public static void addTechSupportSpecialist(TechSupportSpecialist techSupportSpecialist) {
        techSupportSpecialists.add(techSupportSpecialist);
    }
    public static void addResearcherDecorator(ResearcherDecorator researcherDecorator) {
        researchers.add(researcherDecorator);
    }
    public static void addCourse(Course course) {
        courses.add(course);
    }
    public static void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }
    public static void addMark(Mark mark) {
        marks.add(mark);
    }
    public static void addNews(News news) {
    	neews.add(news);
    }
    public static void addMessage(Message message) {
        messages.add(message);
    }
    public static void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }
    public static void addOrder(Order order) {
        orders.add(order);
    }
    public static void addStudentOrganization(StudentOrganization studentOrganization) {
        studentOrganizations.add(studentOrganization);
    }
    public static void addResearchPaper(ResearchPaper researchPaper) {
        researchPapers.add(researchPaper);
    }
    public static void addResearchProject(ResearchProject researchProject) {
        researchProjects.add(researchProject);
    }
    public static void addabcd(abcd abcd) {
        abcds.add(abcd);
    }

    // remove methods
    public static void removeStudent(Student student) {
        students.remove(student);
    }
    public static void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }
    public static void removeAdmin(Admin admin) {
        admins.remove(admin);
    }
    public static void removeManager(Manager manager) {
        managers.remove(manager);
    }
    public static void removeTechSupportSpecialist(TechSupportSpecialist techSupportSpecialist) {
        techSupportSpecialists.remove(techSupportSpecialist);
    }
    public static void removeResearcherDecorator(ResearcherDecorator researcherDecorator) {
        researchers.remove(researcherDecorator);
    }
    public static void removeCourse(Course course) {
        courses.remove(course);
    }
    public static void removeLesson(Lesson lesson) {
        lessons.remove(lesson);
    }
    public static void removeMark(Mark mark) {
        marks.remove(mark);
    }
    public static void removeNews(News news) {
    	neews.remove(news);
    }
    public static void removeMessage(Message message) {
        messages.remove(message);
    }
    public static void removeComplaint(Complaint complaint) {
        complaints.remove(complaint);
    }
    public static void removeOrder(Order order) {
        orders.remove(order);
    }
    public static void removeStudentOrganization(StudentOrganization studentOrganization) {
        studentOrganizations.remove(studentOrganization);
    }
    public static void removeResearchPaper(ResearchPaper researchPaper) {
        researchPapers.remove(researchPaper);
    }
    public static void removeResearchProject(ResearchProject researchProject) {
        researchProjects.remove(researchProject);
    }
    
    
}
