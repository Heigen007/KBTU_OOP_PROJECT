package universityProject;


/**
* @generated
*/
public class Teacher  extends Employee {
    
    /**
    * @generated
    */
    private Course courses;
    
    /**
    * @generated
    */
    private TeacherTitle title;
    
    
    

    /**
    * @generated
    */
    private Course getCourses() {
        return this.courses;
    }
    
    /**
    * @generated
    */
    private Course setCourses(Course courses) {
        this.courses = courses;
    }
    
    
    /**
    * @generated
    */
    private TeacherTitle getTitle() {
        return this.title;
    }
    
    /**
    * @generated
    */
    private TeacherTitle setTitle(TeacherTitle title) {
        this.title = title;
    }
    
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public TeacherTitle getTitle() {
        //TODO
        return universityProject.users.TeacherTitle.TUTOR;
    }
    
    /**
    * @generated
    */
    public Course viewCourses() {
        //TODO
        return null;
    }
    
    
}
