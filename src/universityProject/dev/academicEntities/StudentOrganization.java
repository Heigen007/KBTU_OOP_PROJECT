package universityProject.dev.academicEntities;

import java.util.Vector;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.users.Student;

public class StudentOrganization {

    private int organizationId;
    private Vector<Integer> members;

    public StudentOrganization() {
        this.organizationId = DataRepository.getNextId();
        this.members = new Vector<Integer>();
    }

    public int getOrganizationId() {
        return this.organizationId;
    }

    public Vector<Student> getMembers() {
        Vector<Student> students = new Vector<>();
        for (Integer studentId : this.members) {
            Student student = DataRepository.getStudentById(studentId);
            if (student != null) {
                students.add(student);
            }
        }
        return students;
    }

    public void addMember(int student) {
        this.members.add(student);
    }

    public int getNumberOfMembers() {
        return this.members.size();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        StudentOrganization other = (StudentOrganization) obj;
        return organizationId == other.organizationId;
    }

    @Override
    public String toString() {
        return "StudentOrganization [organizationId=" + organizationId + ", members=" + members + "]";
    }
}