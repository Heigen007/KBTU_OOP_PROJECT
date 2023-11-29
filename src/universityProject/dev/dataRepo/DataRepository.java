package universityProject;

import java.util.Vector;

public class DataRepository {
    private static Vector<Student> students;
    private static Vector<GraduateStudent> graduateStudents;
    private static Vector<Teacher> teachers;
    private static Vector<Admin> admins;
    private static Vector<Manager> managers;
    private static Vector<TechSupportSpecialist> techSupportSpecialists;
    private static Vector<ResearcherDecorator> researchers;
    private static Vector<Course> courses;
    private static Vector<Lesson> lessons;
    private static Vector<Mark> marks;
    private static Vector<News> news;
    private static Vector<Message> messages;
    private static Vector<Complaint> complaints;
    private static Vector<Order> orders;
    private static Vector<StudentOrganization> studentOrganizations;
    private static Vector<ResearchPaper> researchPapers;
    private static Vector<ResearchProject> researchProjects;

    static {
        this.students = new Vector<Student>();
        this.graduateStudents = new Vector<GraduateStudent>();
        this.teachers = new Vector<Teacher>();
        this.admins = new Vector<Admin>();
        this.managers = new Vector<Manager>();
        this.techSupportSpecialists = new Vector<TechSupportSpecialist>();
        this.researchers = new Vector<ResearcherDecorator>();
        this.courses = new Vector<Course>();
        this.lessons = new Vector<Lesson>();
        this.marks = new Vector<Mark>();
        this.news = new Vector<News>();
        this.messages = new Vector<Message>();
        this.complaints = new Vector<Complaint>();
        this.orders = new Vector<Order>();
        this.studentOrganizations = new Vector<StudentOrganization>();
        this.researchPapers = new Vector<ResearchPaper>();
        this.researchProjects = new Vector<ResearchProject>();
    }

    // constructor
    public static DataRepository() {}

    /**
     * Pulls data from the database and populates the static vectors in the DataRepository.
     * This method deserializes data from corresponding files and loads it into the application's memory.
     * It is typically used to initialize or refresh the application's data state from persistent storage.
     */
    public static void pullDataFromDatabase() {
        try {
            students = (Vector<Student>) deserialize("students.dat");
            graduateStudents = (Vector<GraduateStudent>) deserialize("graduateStudents.dat");
            teachers = (Vector<Teacher>) deserialize("teachers.dat");
            admins = (Vector<Admin>) deserialize("admins.dat");
            managers = (Vector<Manager>) deserialize("managers.dat");
            techSupportSpecialists = (Vector<TechSupportSpecialist>) deserialize("techSupportSpecialists.dat");
            researchers = (Vector<ResearcherDecorator>) deserialize("researchers.dat");
            courses = (Vector<Course>) deserialize("courses.dat");
            lessons = (Vector<Lesson>) deserialize("lessons.dat");
            marks = (Vector<Mark>) deserialize("marks.dat");
            news = (Vector<News>) deserialize("news.dat");
            messages = (Vector<Message>) deserialize("messages.dat");
            complaints = (Vector<Complaint>) deserialize("complaints.dat");
            orders = (Vector<Order>) deserialize("orders.dat");
            studentOrganizations = (Vector<StudentOrganization>) deserialize("studentOrganizations.dat");
            researchPapers = (Vector<ResearchPaper>) deserialize("researchPapers.dat");
            researchProjects = (Vector<ResearchProject>) deserialize("researchProjects.dat");
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
            serialize(students, "students.dat");
            serialize(graduateStudents, "graduateStudents.dat");
            serialize(teachers, "teachers.dat");
            serialize(admins, "admins.dat");
            serialize(managers, "managers.dat");
            serialize(techSupportSpecialists, "techSupportSpecialists.dat");
            serialize(researchers, "researchers.dat");
            serialize(courses, "courses.dat");
            serialize(lessons, "lessons.dat");
            serialize(marks, "marks.dat");
            serialize(news, "news.dat");
            serialize(messages, "messages.dat");
            serialize(complaints, "complaints.dat");
            serialize(orders, "orders.dat");
            serialize(studentOrganizations, "studentOrganizations.dat");
            serialize(researchPapers, "researchPapers.dat");
            serialize(researchProjects, "researchProjects.dat");
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
     * in the various vectors like Student, GraduateStudent, Teacher, Admin, Manager, TechSupportSpecialist.
     * It is useful for identifying the current user based on their unique identifier and obtaining
     * their specific data and permissions.
     *
     * @return User the current user of the application, or null if the user is not found.
     */
    public static User getCurrentUser(String userId) {
        User currentUser = findUserInVector(students, userId);
        if (currentUser != null) return currentUser;

        currentUser = findUserInVector(graduateStudents, userId);
        if (currentUser != null) return currentUser;

        currentUser = findUserInVector(teachers, userId);
        if (currentUser != null) return currentUser;

        currentUser = findUserInVector(admins, userId);
        if (currentUser != null) return currentUser;

        currentUser = findUserInVector(managers, userId);
        if (currentUser != null) return currentUser;

        currentUser = findUserInVector(techSupportSpecialists, userId);
        if (currentUser != null) return currentUser;
        
        return null;
    }
    private static <T extends User> User findUserInVector(Vector<T> vector, String userId) {
        for (T user : vector) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }


    // get methods
    public static Student getStudents() {
        return this.students;
    }
    public static GraduateStudent getGraduateStudents() {
        return this.graduateStudents;
    }
    public static Teacher getTeachers() {
        return this.teachers;
    }
    public static Admin getAdmins() {
        return this.admins;
    }
    public static Manager getManagers() {
        return this.managers;
    }
    public static TechSupportSpecialist getTechSupportSpecialists() {
        return this.techSupportSpecialists;
    }
    public static ResearcherDecorator getResearchers() {
        return this.researchers;
    }
    public static Course getCourses() {
        return this.courses;
    }
    public static Lesson getLessons() {
        return this.lessons;
    }
    public static Mark getMarks() {
        return this.marks;
    }
    public static News getNews() {
        return this.news;
    }
    public static Message getMessages() {
        return this.messages;
    }
    public static Complaint getComplaints() {
        return this.complaints;
    }
    public static Order getOrders() {
        return this.orders;
    }
    public static StudentOrganization getStudentOrganizations() {
        return this.studentOrganizations;
    }
    public static ResearchPaper getResearchPapers() {
        return this.researchPapers;
    }
    public static ResearchProject getResearchProjects() {
        return this.researchProjects;
    }

    // add methods
    public static void addStudent(Student student) {
        this.students.add(student);
    }
    public static void addGraduateStudent(GraduateStudent graduateStudent) {
        this.graduateStudents.add(graduateStudent);
    }
    public static void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }
    public static void addAdmin(Admin admin) {
        this.admins.add(admin);
    }
    public static void addManager(Manager manager) {
        this.managers.add(manager);
    }
    public static void addTechSupportSpecialist(TechSupportSpecialist techSupportSpecialist) {
        this.techSupportSpecialists.add(techSupportSpecialist);
    }
    public static void addResearcherDecorator(ResearcherDecorator researcherDecorator) {
        this.researchers.add(researcherDecorator);
    }
    public static void addCourse(Course course) {
        this.courses.add(course);
    }
    public static void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }
    public static void addMark(Mark mark) {
        this.marks.add(mark);
    }
    public static void addNews(News news) {
        this.news.add(news);
    }
    public static void addMessage(Message message) {
        this.messages.add(message);
    }
    public static void addComplaint(Complaint complaint) {
        this.complaints.add(complaint);
    }
    public static void addOrder(Order order) {
        this.orders.add(order);
    }
    public static void addStudentOrganization(StudentOrganization studentOrganization) {
        this.studentOrganizations.add(studentOrganization);
    }
    public static void addResearchPaper(ResearchPaper researchPaper) {
        this.researchPapers.add(researchPaper);
    }
    public static void addResearchProject(ResearchProject researchProject) {
        this.researchProjects.add(researchProject);
    }

    // remove methods
    public static void removeStudent(Student student) {
        this.students.remove(student);
    }
    public static void removeGraduateStudent(GraduateStudent graduateStudent) {
        this.graduateStudents.remove(graduateStudent);
    }
    public static void removeTeacher(Teacher teacher) {
        this.teachers.remove(teacher);
    }
    public static void removeAdmin(Admin admin) {
        this.admins.remove(admin);
    }
    public static void removeManager(Manager manager) {
        this.managers.remove(manager);
    }
    public static void removeTechSupportSpecialist(TechSupportSpecialist techSupportSpecialist) {
        this.techSupportSpecialists.remove(techSupportSpecialist);
    }
    public static void removeResearcherDecorator(ResearcherDecorator researcherDecorator) {
        this.researchers.remove(researcherDecorator);
    }
    public static void removeCourse(Course course) {
        this.courses.remove(course);
    }
    public static void removeLesson(Lesson lesson) {
        this.lessons.remove(lesson);
    }
    public static void removeMark(Mark mark) {
        this.marks.remove(mark);
    }
    public static void removeNews(News news) {
        this.news.remove(news);
    }
    public static void removeMessage(Message message) {
        this.messages.remove(message);
    }
    public static void removeComplaint(Complaint complaint) {
        this.complaints.remove(complaint);
    }
    public static void removeOrder(Order order) {
        this.orders.remove(order);
    }
    public static void removeStudentOrganization(StudentOrganization studentOrganization) {
        this.studentOrganizations.remove(studentOrganization);
    }
    public static void removeResearchPaper(ResearchPaper researchPaper) {
        this.researchPapers.remove(researchPaper);
    }
    public static void removeResearchProject(ResearchProject researchProject) {
        this.researchProjects.remove(researchProject);
    }
    
    
}
