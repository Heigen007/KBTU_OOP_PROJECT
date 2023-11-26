package universityProject;


/**
* @generated
*/
public class ResearcherDecorator  extends UserDecorator {
    
    /**
    * @generated
    */
    private int hIndex;
    
    /**
    * @generated
    */
    private ResearchPaper researchPapers;
    
    /**
    * @generated
    */
    private ResearchProject researchProjects;
    
    
    

    /**
    * @generated
    */
    private int getHIndex() {
        return this.hIndex;
    }
    
    /**
    * @generated
    */
    private int setHIndex(Integer hIndex) {
        this.hIndex = hIndex;
    }
    
    
    /**
    * @generated
    */
    private ResearchPaper getResearchPapers() {
        return this.researchPapers;
    }
    
    /**
    * @generated
    */
    private ResearchPaper setResearchPapers(ResearchPaper researchPapers) {
        this.researchPapers = researchPapers;
    }
    
    
    /**
    * @generated
    */
    private ResearchProject getResearchProjects() {
        return this.researchProjects;
    }
    
    /**
    * @generated
    */
    private ResearchProject setResearchProjects(ResearchProject researchProjects) {
        this.researchProjects = researchProjects;
    }
    
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public int calculateHIndex() {
        //TODO
        return 0;
    }
    
    
}
