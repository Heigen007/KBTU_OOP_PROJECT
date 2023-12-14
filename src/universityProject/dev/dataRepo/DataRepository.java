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
    private static Vector<Employee> employees;
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
    private static Vector<Journal> journals;
	private static Vector<abcd> abcds;

    private static int indexCounter = 0;

    static {
        employees = new Vector<Employee>();
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
        journals = new Vector<Journal>();
        abcds = new Vector<abcd>();

        try {
            indexCounter = (int) deserialize("data/indexCounter.dat");
        } catch (IOException | ClassNotFoundException e) {
            indexCounter = 0;
            e.printStackTrace();
        }
    }
    // constructor
    public DataRepository() {}

    public static int getNextId() {
        return ++indexCounter; // Increment and return the counter
    }

    /**
     * Pulls data from the database and populates the static vectors in the DataRepository.
     * This method deserializes data from corresponding files and loads it into the application's memory.
     * It is typically used to initialize or refresh the application's data state from persistent storage.
     */
    @SuppressWarnings("unchecked")
	public static void pullDataFromDatabase() {
        try {
            employees = (Vector<Employee>) deserialize("data/employees.dat");
            students = (Vector<Student>) deserialize("data/students.dat");
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
            journals = (Vector<Journal>) deserialize("data/journals.dat");
            abcds = (Vector<abcd>) deserialize("data/abcds.dat");
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
            serialize(employees, "data/employees.dat");
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
            serialize(journals, "data/journals.dat");

            serialize(indexCounter, "data/indexCounter.dat");
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
    public static User login(String userName, String password) {
        pullDataFromDatabase();
        // create a vector of vectors we will iterate through
        Vector<Vector<? extends User>> vectors = new Vector<>();
        vectors.add(employees);
        vectors.add(students);
        vectors.add(teachers);
        vectors.add(admins);
        vectors.add(managers);
        vectors.add(techSupportSpecialists);

        // iterate through the vectors and search for the user
       for (Vector<? extends User> vector : vectors) {
           for (User user : vector) {
               if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                   return user;
               }
           }
       }
        return null;
    }

    public static void logout() {
        saveTransactionDataToDB();
    }

    public static User getUserById(int id) {
        User user = getStudentById(id);
        if (user == null) {
            user = getTeacherById(id);
        }
        if (user == null) {
            user = getAdminById(id);
        }
        if (user == null) {
            user = getManagerById(id);
        }
        if (user == null) {
            user = getTechSupportSpecialistById(id);
        }
        if (user == null) {
            user = getResearcherById(id);
        }
        if (user == null) {
            user = getEmployeeById(id);
        }
        return user;
    }


    // get methods
    public static Vector<Employee> getEmployees() {
        return employees;
    }
    public static Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public static Vector<Student> getStudents() {
        return students;
    }
    public static Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    public static Vector<Teacher> getTeachers() {
        return teachers;
    }
    public static Teacher getTeacherById(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }
    public static Vector<Admin> getAdmins() {
        return admins;
    }
    public static Admin getAdminById(int id) {
        for (Admin admin : admins) {
            if (admin.getId() == id) {
                return admin;
            }
        }
        return null;
    }
    public static Vector<Manager> getManagers() {
        return managers;
    }
    public static Manager getManagerById(int id) {
        for (Manager manager : managers) {
            if (manager.getId() == id) {
                return manager;
            }
        }
        return null;
    }
    public static Vector<TechSupportSpecialist> getTechSupportSpecialists() {
        return techSupportSpecialists;
    }
    public static TechSupportSpecialist getTechSupportSpecialistById(int id) {
        for (TechSupportSpecialist techSupportSpecialist : techSupportSpecialists) {
            if (techSupportSpecialist.getId() == id) {
                return techSupportSpecialist;
            }
        }
        return null;
    }
    public static Vector<ResearcherDecorator> getResearchers() {
        return researchers;
    }
    public static ResearcherDecorator getResearcherById(int id) {
        for (ResearcherDecorator researcherDecorator : researchers) {
            if (researcherDecorator.getId() == id) {
                return researcherDecorator;
            }
        }
        return null;
    }
    public static Vector<Course> getCourses() {
        return courses;
    }
    public static Course getCourseById(int courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }
    public static Vector<Lesson> getLessons() {
        return lessons;
    }
    public static Lesson getLessonById(int lessonId) {
        for (Lesson lesson : lessons) {
            if (lesson.getLessonId() == lessonId) {
                return lesson;
            }
        }
        return null;
    }
    public static Vector<Mark> getMarks() {
        return marks;
    }
    public static Mark getMarkById(int markId) {
        for (Mark mark : marks) {
            if (mark.getMarkId() == markId) {
                return mark;
            }
        }
        return null;
    }
    public static Vector<News> getNews() {
        return neews;
    }
    public static News getNewsById(int newsId) {
        for (News news : neews) {
            if (news.getNewsId() == newsId) {
                return news;
            }
        }
        return null;
    }
    public static Vector<Message> getMessages() {
        return messages;
    }
    public static Message getMessageById(int messageId) {
        for (Message message : messages) {
            if (message.getMessageId() == messageId) {
                return message;
            }
        }
        return null;
    }
    public static Vector<Complaint> getComplaints() {
        return complaints;
    }
    public static Complaint getComplaintById(int complaintId) {
        for (Complaint complaint : complaints) {
            if (complaint.getComplaintId() == complaintId) {
                return complaint;
            }
        }
        return null;
    }
    public static Vector<Order> getOrders() {
        return orders;
    }
    public static Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }
    public static Vector<StudentOrganization> getStudentOrganizations() {
        return studentOrganizations;
    }
    public static StudentOrganization getStudentOrganizationById(int studentOrganizationId) {
        for (StudentOrganization studentOrganization : studentOrganizations) {
            if (studentOrganization.getStudentOrganizationId() == studentOrganizationId) {
                return studentOrganization;
            }
        }
        return null;
    }
    public static Vector<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }
    public static ResearchPaper getResearchPaperById(int researchPaperId) {
        for (ResearchPaper researchPaper : researchPapers) {
            if (researchPaper.getPaperId() == researchPaperId) {
                return researchPaper;
            }
        }
        return null;
    }
    public static Vector<ResearchProject> getResearchProjects() {
        return researchProjects;
    }
    public static ResearchProject getResearchProjectById(int researchProjectId) {
        for (ResearchProject researchProject : researchProjects) {
            if (researchProject.getProjectId() == researchProjectId) {
                return researchProject;
            }
        }
        return null;
    }
    public static Vector<Journal> getJournals() {
        return journals;
    }
    public static Journal getJournalById(int journalId) {
        for (Journal journal : journals) {
            if (journal.getJournalId() == journalId) {
                return journal;
            }
        }
        return null;
    }
    public static Vector<abcd> getabcds() {
        return abcds;
    }


    // add methods
    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }
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
    public static void addJournal(Journal journal) {
        journals.add(journal);
    }
    public static void addabcd(abcd abcd) {
        abcds.add(abcd);
    }

    // remove methods
    public static void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
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
    public static void removeJournal(Journal journal) {
        journals.remove(journal);
    }
    public static void removeResearchProject(ResearchProject researchProject) {
        researchProjects.remove(researchProject);
    }
    
    
}
