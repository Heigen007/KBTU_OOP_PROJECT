package universityProject;


/**
* @generated
*/
public class Manager  extends Employee {
    
    /**
    * @generated
    */
    private ManagerType managerType;
    
    
    

    /**
    * @generated
    */
    private ManagerType getManagerType() {
        return this.managerType;
    }
    
    /**
    * @generated
    */
    private ManagerType setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }
    
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public ManagerType getManagerType() {
        //TODO
        return universityProject.users.ManagerType.OR;
    }
    
    /**
    * @generated
    */
    public Complaint viewComplaints() {
        //TODO
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
