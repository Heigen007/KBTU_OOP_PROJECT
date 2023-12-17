package universityProject.dev.users;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.logs.*;

public class Admin extends Employee {
	
	public Admin() {
		super();
	}
    
	public Admin(String name, String email, String password) {
		super(name, email, password, false);
	}

	public void addAdmin(String name, String email, String password) {
		Admin admin = new Admin(name, email, password);
		DataRepository.addAdmin(admin);
	}

    public void addEmployee(String name, String email, String password, Boolean isResearcher) {
        Employee employee = new Employee(name, email, password, isResearcher);
        DataRepository.addEmployee(employee);
        if(isResearcher) {
        	ResearcherDecorator researcher = new ResearcherDecorator(employee.getUserId());
            DataRepository.addResearcherDecorator(researcher);
        }
    }
	
	public void addTeacher(String name, String email, String password, Boolean isResearcher, TeacherTitle teacherTitle) {
        Teacher teacher = new Teacher(name, email, password, isResearcher, teacherTitle);
        DataRepository.addTeacher(teacher);
        if(isResearcher) {
        	ResearcherDecorator researcher = new ResearcherDecorator(teacher.getUserId());
            DataRepository.addResearcherDecorator(researcher);
        }
	}
	
	public void addStudent(String name, String email, String password, Boolean isResearcher, DegreeType degreeType) {
        Student student = new Student(name, email, password, isResearcher, degreeType);
        DataRepository.addStudent(student);
        if(isResearcher) {
        	ResearcherDecorator researcher = new ResearcherDecorator(student.getUserId());
            DataRepository.addResearcherDecorator(researcher);
        }
    }
	
	public void addManager(String name, String email, String password, ManagerType managerType) {
        Manager manager = new Manager(name, email, password, ManagerType.OR);
        DataRepository.addManager(manager);
	}
	
	public void addTechSupportSpecialist(String name, String email, String password) {
        TechSupportSpecialist techSupportSpecialist = new TechSupportSpecialist(name, email, password);
        DataRepository.addTechSupportSpecialist(techSupportSpecialist);
    }

    public void removeEmployee(Employee employee) {
        DataRepository.removeEmployee(employee);
    }

    public void removeAdmin(Admin admin) {
        DataRepository.removeAdmin(admin);
    }

    public void removeTeacher(Teacher teacher) {
        DataRepository.removeTeacher(teacher);
    }

    public void removeStudent(Student student) {
        DataRepository.removeStudent(student);
    }

    public void removeManager(Manager manager) {
        DataRepository.removeManager(manager);
    }

    public void removeTechSupportSpecialist(TechSupportSpecialist techSupportSpecialist) {
        DataRepository.removeTechSupportSpecialist(techSupportSpecialist);
    }

    public void viewLogs() {
        System.out.println("Logs:");
        for (LogRecord log : LogsSettings.getLogs()) {
            System.out.println(log);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
