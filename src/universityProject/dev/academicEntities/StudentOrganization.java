package universityProject.dev.academicEntities;

import java.io.Serializable;
import java.util.Vector;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.users.Student;

/**
 * @author Asyl
 * @version 18.12.2023
 * The StudentOrganization class represents a student organization within the university.
 * It contains information such as the organization ID and a list of members.
 */
public class StudentOrganization implements Serializable {

    /** The unique identifier for the student organization. */
    private int organizationId;

    /** The list of member IDs belonging to the organization. */
    private Vector<Integer> members;

    /** Default constructor for the StudentOrganization class. */
    public StudentOrganization() {
        this.organizationId = DataRepository.getNextId();
        this.members = new Vector<Integer>();
    }

    /**
     * Retrieves the organization ID.
     *
     * @return The organization ID.
     */
    public int getOrganizationId() {
        return this.organizationId;
    }

    /**
     * Retrieves the list of members belonging to the organization.
     *
     * @return A vector containing the members of the organization.
     */
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

    /**
     * Adds a member to the organization.
     *
     * @param student The ID of the student to be added as a member.
     */
    public void addMember(int student) {
        this.members.add(student);
    }

    /**
     * Retrieves the number of members in the organization.
     *
     * @return The number of members in the organization.
     */
    public int getNumberOfMembers() {
        return this.members.size();
    }

    /**
     * Checks if two StudentOrganization objects are equal based on their organization ID.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        StudentOrganization other = (StudentOrganization) obj;
        return organizationId == other.organizationId;
    }

    /**
     * Generates a string representation of the StudentOrganization object.
     *
     * @return A string representation of the StudentOrganization object.
     */
    @Override
    public String toString() {
        return "StudentOrganization [organizationId=" + organizationId + ", members=" + members + "]";
    }
}
