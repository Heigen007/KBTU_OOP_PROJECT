/**
 * The Admin class represents an administrator in the university project system,
 * extending the functionality provided by the base Employee class.
 *
 * @version 1.0
 * @author Zhanibek
 */
package universityProject.dev.users;

import universityProject.Employee;
import universityProject.Manager;
import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.logs.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Admin extends Employee {
	/**
     * Default constructor for creating an Admin object.
     */
	public Admin() {
		super();
        createLogRecord("Admin created");
	}
	/**
     * Constructor for creating an Admin object with specified parameters.
     *
     * @param name     The name of the administrator.
     * @param email    The email address of the administrator.
     * @param password The password for the administrator.
     */
	public Admin(String name, String email, String password) {
		super(name, email, password, false);
        createLogRecord("Admin created");
	}
	/**
     * Add a new administrator to the system with the specified parameters.
     *
     * @param name     The name of the new administrator.
     * @param email    The email address of the new administrator.
     * @param password The password for the new administrator.
     */
	public void addAdmin(String name, String email, String password) {
		Admin admin = new Admin(name, email, password);
		DataRepository.addAdmin(admin);
        createLogRecord("Admin added admin");
	}
	/**
     * Add a new employee to the system with the specified parameters.
     *
     * @param name         The name of the new employee.
     * @param email        The email address of the new employee.
     * @param password     The password for the new employee.
     * @param isResearcher Indicates whether the employee is a researcher.
     */
    public void addEmployee(String name, String email, String password, Boolean isResearcher) {
        Employee employee = new Employee(name, email, password, isResearcher);
        DataRepository.addEmployee(employee);
        if(isResearcher) {
        	ResearcherDecorator researcher = new ResearcherDecorator(employee.getUserId());
            DataRepository.addResearcherDecorator(researcher);
        }
        createLogRecord("Admin added employee");
    }
    /**
     * Add a new teacher to the system with the specified parameters.
     *
     * @param name         The name of the new teacher.
     * @param email        The email address of the new teacher.
     * @param password     The password for the new teacher.
     * @param isResearcher Indicates whether the teacher is a researcher.
     * @param teacherTitle The title of the new teacher.
     */
	public void addTeacher(String name, String email, String password, Boolean isResearcher, TeacherTitle teacherTitle) {
        Teacher teacher = new Teacher(name, email, password, isResearcher, teacherTitle);
        DataRepository.addTeacher(teacher);
        if(isResearcher) {
        	ResearcherDecorator researcher = new ResearcherDecorator(teacher.getUserId());
            DataRepository.addResearcherDecorator(researcher);
        }
        createLogRecord("Admin added teacher");
	}
	/**
     * Add a new student to the system with the specified parameters.
     *
     * @param name         The name of the new student.
     * @param email        The email address of the new student.
     * @param password     The password for the new student.
     * @param isResearcher Indicates whether the student is a researcher.
     * @param degreeType   The degree type of the new student.
     */
	public void addStudent(String name, String email, String password, Boolean isResearcher, DegreeType degreeType) {
        Student student = new Student(name, email, password, isResearcher, degreeType);
        DataRepository.addStudent(student);
        if(isResearcher) {
        	ResearcherDecorator researcher = new ResearcherDecorator(student.getUserId());
            DataRepository.addResearcherDecorator(researcher);
        }
        createLogRecord("Admin added student");
    }
	/**
     * Add a new manager to the system with the specified parameters.
     *
     * @param name        The name of the new manager.
     * @param email       The email address of the new manager.
     * @param password    The password for the new manager.
     * @param managerType The type of the new manager.
     */
	public void addManager(String name, String email, String password, ManagerType managerType) {
        Manager manager = new Manager(name, email, password, ManagerType.OR);
        DataRepository.addManager(manager);
        createLogRecord("Admin added manager");
	}
	/**
     * Add a new technical support specialist to the system with the specified parameters.
     *
     * @param name     The name of the new technical support specialist.
     * @param email    The email address of the new technical support specialist.
     * @param password The password for the new technical support specialist.
     */
	public void addTechSupportSpecialist(String name, String email, String password) {
        TechSupportSpecialist techSupportSpecialist = new TechSupportSpecialist(name, email, password);
        DataRepository.addTechSupportSpecialist(techSupportSpecialist);
        createLogRecord("Admin added tech-support specialist");
    }
	/**
     * Remove an employee from the system.
     *
     * @param employee The employee to remove.
     */
    public void removeEmployee(Employee employee) {
        DataRepository.removeEmployee(employee);
        createLogRecord("Admin removed employee" + "(" + employee.getUserId() + ")");
    }
    /**
     * Remove an administrator from the system.
     *
     * @param admin The administrator to remove.
     */
    public void removeAdmin(Admin admin) {
        DataRepository.removeAdmin(admin);
        createLogRecord("Admin removed admin - " + admin.getUserId() );
    }
    /**
     * Remove a teacher from the system.
     *
     * @param teacher The teacher to remove.
     */
    public void removeTeacher(Teacher teacher) {
        DataRepository.removeTeacher(teacher);
        createLogRecord("Admin removed teacher - " + teacher.getUserId() );
    }
    /**
     * Remove a student from the system.
     *
     * @param student The student to remove.
     */
    public void removeStudent(universityProject.dev.users.Student student) {
        DataRepository.removeStudent(student);
        createLogRecord("Admin removed student - " + student.getUserId() );
    }
    /**
     * Remove a manager from the system.
     *
     * @param manager The manager to remove.
     */
    public void removeManager(Manager manager) {
        DataRepository.removeManager(manager);
        createLogRecord("Admin removed manager - " + manager.getUserId() );
    }
    /**
     * Remove a technical support specialist from the system.
     *
     * @param techSupportSpecialist The technical support specialist to remove.
     */
    public void removeTechSupportSpecialist(TechSupportSpecialist techSupportSpecialist) {
        DataRepository.removeTechSupportSpecialist(techSupportSpecialist);
        createLogRecord("Admin removed tech-support specialist - " + techSupportSpecialist.getUserId() );
    }
    /**
     * View system logs.
     */
    public void viewLogs() {
        System.out.println("Logs:");
        for (LogRecord log : LogsSettings.getLogs()) {
            System.out.println(log);
        }
    }


    public void createLogRecord(String text){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        universityProject.dev.logs.LogRecord logRecord = new universityProject.dev.logs.LogRecord(this.getUserId(), formattedDateTime, text);
        universityProject.dev.logs.LogsSettings.addLogRecord(logRecord);
    }
    /**
     * Overrides the equals method of the base class to compare Admin objects.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
