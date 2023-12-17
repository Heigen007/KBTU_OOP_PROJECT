package universityProject.dev.academicEntities;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.users.Student;

public class StudentRegistration {
    private int registartionId;
    private Integer student;
    private Integer course;

    public StudentRegistration() {
    }

    public StudentRegistration(Integer student, Integer course) {
        this.registartionId = DataRepository.getNextId();
        this.student = student;
        this.course = course;
    }

    public int getRegistrationId() {
        return this.registartionId;
    }

    public Student getStudent() {
        return DataRepository.getStudentById(this.student);
    }

    public Course getCourse() {
        return DataRepository.getCourseById(this.course);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        StudentRegistration other = (StudentRegistration) obj;
        return registartionId == other.registartionId;
    }

    @Override
    public String toString() {
        return "StudentRegistration [registartionId=" + registartionId + ", student=" + student + ", course=" + course
                + "]";
    }
}
