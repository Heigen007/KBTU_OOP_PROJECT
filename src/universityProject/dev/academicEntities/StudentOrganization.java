package universityProject;

public class StudentOrganization {

    private int organizationId;
    private Student members;

    // Конструктор без параметров
    public StudentOrganization() {
    }

    // Конструктор с параметрами
    public StudentOrganization(int organizationId, Student members) {
        this.organizationId = organizationId;
        this.members = members;
    }

    // Геттеры и сеттеры

    public int getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public Student getMembers() {
        return this.members;
    }

    public void setMembers(Student members) {
        this.members = members;
    }
//Operations
    public int getNumberOfMembers() {
        //TODO
        return 0;
    }
    
    
}
