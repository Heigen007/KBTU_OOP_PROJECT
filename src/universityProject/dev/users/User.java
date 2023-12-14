package universityProject.dev.users;

import java.util.Vector;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.academicEntities.Order;
import universityProject.dev.academicEntities.Status;
import universityProject.dev.academicEntities.News;
import universityProject.dev.academicEntities.Message;

import universityProject.dev.logs.*;

public abstract class User {
    
	private int userId;
	private String name;
	private String email;
	private String password;
	private Boolean isResearcher;
	
	public User() {
	}
	
	public User(String name, String email, String password, Boolean isReseacher) {
		this.userId = DataRepository.getNextId();
		this.email = email;
		this.isResearcher = isReseacher;
		this.name = name;
		this.password = password;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return name;
	}
	
	public String getUserEmail() {
		return email;
	}
	
	public String getUserPassword() {
		return password;
	}

    public Boolean getUserIsResearcher() {
        return isResearcher;
    }
	
	public User login(String enteredName, String enteredPassword) {
        User user = DataRepository.login(enteredName, enteredPassword);
	    if(user != null) {
            return user;
        } else {
            System.out.println("Login failed");
        }
	    return null;
	}
	
	public void logout() {
        DataRepository.logout();
	}
	
	public boolean updateProfile(String name, String email, String password, Boolean isResearcher) {
        // Валидация email
        if (!isValidEmail(email)) {
            return false;
        }

        this.name = name;
        this.email = email;
        this.password = password;

        return true;
    }

    private boolean isValidEmail(String email) {
        // Проверка формата email с использованием регулярного выражения
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    public void createOrder(String problemText) {
    	 Order order = new Order(problemText, Status.CREATED);
        DataRepository.addOrder(order);
    }

    public void createLogRecord(String text){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        LogRecord logRecord = new LogRecord(this.userId, formattedDateTime, text);
        LogsSettings.addLogRecord(logRecord);
    }

    public void viewNews() {
        Vector<News> news = DataRepository.getNews();
        for (News n : news) {
            System.out.println(n);
        }
    }

    public void sendMessage(int receiver, String content) {
        Message message = new Message(this.userId, receiver, content);
        DataRepository.addMessage(message);
    }

    public void viewMessages() {
        Vector<Message> messages = DataRepository.getMessages();
        for (Message m : messages) {
            System.out.println(m);
        }
    }
}
