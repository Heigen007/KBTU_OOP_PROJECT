package universityProject;


import java.util.ArrayList;

/**
* @generated
*/
public class Student extends User {
    private Course enrolledCourses;
    private int credits;
    private Mark marks;
    private StudentOrganization studentOrganizations;

    private Course getEnrolledCourses() {
        return this.enrolledCourses;
    }

    private void setEnrolledCourses(Course enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    private int getCredits() {
        return this.credits;
    }

    private void setCredits(Integer credits) {
        this.credits = credits;
    }

    private Mark getMarks() {
        return this.marks;
    }

    private void setMarks(Mark marks) {
        this.marks = marks;
    }

    private StudentOrganization getStudentOrganizations() {
        return this.studentOrganizations;
    }

    private void setStudentOrganizations(StudentOrganization studentOrganizations) {
        this.studentOrganizations = studentOrganizations;
    }



    public void viewTranscript() {
        //TODO
    }

    public String getDegreeType() {
        //TODO
        return "";
    }

    public boolean isEligibleForCourse() {
        //TODO
        return false;
    }

    public void putRateToTeacher(int teachersId, double mark){
        for (Teacher teacher: universityProject.dev.dataRepo.DataRepository.getTeachers()){
            if(teacher.getUserID()==teachersId){
                teacher.addRate(mark);
            }
        }
    }
    
    
}
