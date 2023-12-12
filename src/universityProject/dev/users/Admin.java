package universityProject.dev.users;

import universityProject.dev.dataRepo.DataRepository;
/**
* @generated
*/
public class Admin extends Employee {
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Admin(Integer userId, String name, String email, String password, Boolean isReseacher) {
		super(userId, name, email, password, isReseacher);
		// TODO Auto-generated constructor stub
	}



	public void addAdmin(Integer userId, String name, String email, String password, Boolean isReseacher) {
		Admin admin = new Admin(userId, name, email, password, isReseacher);
		DataRepository.addAdmin(admin);
	}
	
	public void addTeacher() {
		
	}
	
	public void addStudent() {
		
	}
	
	public void addManager() {
		
	}
	
	public void addTechSupportSpecialist() {
		
	}
    
    

    
    

    //                          Operations                                  
    
    
}
