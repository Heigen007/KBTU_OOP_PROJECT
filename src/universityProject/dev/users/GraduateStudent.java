package universityProject;


/**
* @generated
*/
public class GraduateStudent  extends Student {
    
    /**
    * @generated
    */
    private ResearcherDecorator researchSupervisor ;
    
    /**
    * @generated
    */
    private DegreeType degreeType;
    
    /**
    * @generated
    */
    private ResearcherDecorator assignedSupervisor;
    
    
    

    /**
    * @generated
    */
    private ResearcherDecorator getResearchSupervisor () {
        return this.researchSupervisor ;
    }
    
    /**
    * @generated
    */
    private ResearcherDecorator setResearchSupervisor (ResearcherDecorator  researchSupervisor ) {
        this.researchSupervisor  = researchSupervisor ;
    }
    
    
    /**
    * @generated
    */
    private DegreeType getDegreeType() {
        return this.degreeType;
    }
    
    /**
    * @generated
    */
    private DegreeType setDegreeType(DegreeType degreeType) {
        this.degreeType = degreeType;
    }
    
    
    /**
    * @generated
    */
    private ResearcherDecorator getAssignedSupervisor() {
        return this.assignedSupervisor;
    }
    
    /**
    * @generated
    */
    private ResearcherDecorator setAssignedSupervisor(ResearcherDecorator  assignedSupervisor) {
        this.assignedSupervisor = assignedSupervisor;
    }
    
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public void getResearchSupervisor() {
        //TODO
    }
    
    /**
    * @generated
    */
    public DegreeType getDegreeType() {
        //TODO
        return universityProject.users.DegreeType.MASTER;
    }
    
    
}
