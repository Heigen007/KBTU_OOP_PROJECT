package universityProject.dev.users;

import java.util.Vector;

import universityProject.dev.academicEntities.Message;
import universityProject.dev.dataRepo.DataRepository;

/**
* @generated
*/
public class Employee extends User {
    
    
	
    public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(Integer userId, String name, String email, String password, Boolean isReseacher) {
		super(userId, name, email, password, isReseacher);
		// TODO Auto-generated constructor stub
	}


	public void sendMessages(String text, User recipient) {
    	Message message = new Message(text, this, recipient);
    	
    	DataRepository.addMessage(message);
    }

    
    public void viewMessages() {
        Vector<Message> allMessages = DataRepository.getMessages();
        
        // Фильтруем сообщения, оставляя только те, которые адресованы текущему юзеру
        for (Message message : allMessages) {
            if (message.getRecieverUser().getName().equals(this.getName())) {
                System.out.println(message.getContent());
            }
        }
    }

    //                          Operations                                  
    
    
}
