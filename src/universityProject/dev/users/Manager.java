package universityProject.dev.users;

import universityProject.dev.academicEntities.*;
import universityProject.dev.academicEntities.Course;
import universityProject.dev.dataRepo.DataRepository;

/**
* @generated
*/
public class Manager  extends Employee {
    
    private ManagerType managerType;
    
    public ManagerType getManagerType() {
        //TODO
        return this.managerType;
    }
    
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(Integer userId, String name, String email, String password, Boolean isReseacher, ManagerType managerType) {
		super(userId, name, email, password, isReseacher);
		// TODO Auto-generated constructor stub
		this.managerType = managerType;
	}



	public void approveStudentRegistration(Student student, Course course) {
        if (student != null && course != null) {
            // Подтверждаем регистрацию
            System.out.println("Регистрация студента " + student.getName() + " на курс " + course.getCourseName() + " подтверждена.");
            // Добавляем курс в список записанных курсов студента
            addCourseToStudent(student, course);
        } else {
            System.out.println("Неверно указан студент или курс для регистрации.");
        }
    }
    
	public void viewInfoAboutStudents() {
        System.out.println("Информация о студентах:");
        System.out.println("-------------------------------");

        for (Student student : DataRepository.getStudents()) {
            System.out.println("ID: " + student.getUserId());
            System.out.println("Имя: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("------------------------------");
        }
    }
    
	public void viewInfoAboutTeachers() {
        System.out.println("Информация о учителях:");
        System.out.println("-------------------------------");

        for (Teacher teacher : DataRepository.getTeachers()) {
            System.out.println("ID: " + teacher.getUserId());
            System.out.println("Имя: " + teacher.getName());
            System.out.println("Email: " + teacher.getEmail());
            System.out.println("------------------------------");
        }
    }
	
    public void publishNews(String title, String content) {
        if (title != null && content != null && !title.isEmpty() && !content.isEmpty()) {
            // Создаем новость
            News news = new News(DataRepository.getNews().size() + 1, title, content);

            // Добавляем новость в репозиторий данных
            DataRepository.addNews(news);

            System.out.println("Новость успешно опубликована.");
        } else {
            System.out.println("Заголовок и содержание новости не могут быть пустыми.");
        }
    }
    
    public void createStudentOrganization() {
        // Создаем новую студенческую организацию
        StudentOrganization organization = new StudentOrganization(DataRepository.getStudentOrganizations().size() + 1);

        // Добавляем организацию в репозиторий данных
        DataRepository.addStudentOrganization(organization);

        System.out.println("Студенческая организация успешно создана.");
    }
    
    public void viewComplaints() {
        System.out.println("Список жалоб:");
        System.out.println("-------------------------------");

        for (Complaint complaint : DataRepository.getComplaints()) {
            System.out.println("ID: " + complaint.getComplaintId());
            System.out.println("Текст жалобы: " + complaint.getComplaintText());
            System.out.println("Уровень срочности: " + complaint.getUrgencyLevel());
            System.out.println("Отправитель: " + complaint.getComplaintSender().getName());
            System.out.println("Виновник: " + complaint.getComplaintGuilty().getName());
            System.out.println("Статус: " + complaint.getComplaintStatus());
            System.out.println("------------------------------");
        }

    }
    
    public void changeComplaintStatus(int complaintId) {
        Complaint complaint = findComplaintById(complaintId);

        if (complaint != null) {
            // Изменяем статус жалобы
            complaint.changeStatus();
            System.out.println("Статус жалобы успешно изменен.");
        } else {
            System.out.println("Жалоба с указанным ID не найдена.");
        }
    }

    private Complaint findComplaintById(int complaintId) {
        // Ищем жалобу по ID в репозитории данных
        for (Complaint complaint : DataRepository.getComplaints()) {
            if (complaint.getComplaintId() == complaintId) {
                return complaint;
            }
        }
        return null;
    }


    public double viewAverageRate(int teachersId){
        for (Teacher teacher: universityProject.dev.dataRepo.DataRepository.getTeachers()){
            if(teacher.getUserID()==teachersId){
                return teacher.getAverageRate();
            }
        }
        return -1;// need catch exception of not finding
    }
    
    
}
