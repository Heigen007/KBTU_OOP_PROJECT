/**
 * The User class represents the abstract base class for users in the system.
 * It provides essential methods for managing user profiles, logging in and out,
 * creating orders, sending messages, and other operations.
 *
 * @version 1.0
 * @author Zhanibek
 */
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
	/**
     * Unique identifier of the user.
     */
	private int userId;
	/**
	 *User's name.
	 */
	private String name;
	/**
	 * User's emaail address.
	 */
	private String email;
	/**
	 * User's password.
	 */
	private String password;
	/**
	 * Flag indicating whether the user is a researcher (true if the user is a researcher, false otherwise).
	 */
	private Boolean isResearcher;
	/**
	 * Default constructor
	 */
	public User() {
	}
	 /**
     * Constructor to create a new user with the specified parameters.
     *
     * @param name         User's name.
     * @param email        User's email address.
     * @param password     User's password.
     * @param isReseacher  Flag indicating whether the user is a researcher.
     */
	public User(String name, String email, String password, Boolean isReseacher) {
		this.userId = DataRepository.getNextId();
		this.email = email;
		this.isResearcher = isReseacher;
		this.name = name;
		this.password = password;
	}
	/**
	 * Get the unique identifier of the user.
	 * 
	 * @return Unique identifier of the user.
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * Get the name of the user.
	 * 
	 * @return User's name.
	 */
	public String getUserName() {
		return name;
	}
	/**
	 * Get the email of the user.
	 * 
	 * @return User's email
	 */
	public String getUserEmail() {
		return email;
	}
	/**
	 * Get the password of the user.
	 * 
	 * @return User's password.
	 */
	public String getUserPassword() {
		return password;
	}
	/**
	 * Check whether the user is a researcher
	 *  
	 * @return true if the user is a researcher, false otherwise.
	 */
    public Boolean getUserIsResearcher() {
        return isResearcher;
    }
	/**
	 * Method for user login.
	 * 
	 * @param enteredName     Entered username
	 * @param enteredPassword Entered user password
	 * @return User object if login is successful, otherwise null.
	 */
	public User login(String enteredName, String enteredPassword) {
        User user = DataRepository.login(enteredName, enteredPassword);
	    if(user != null) {
            return user;
        } else {
            System.out.println("Login failed");
        }
	    return null;
	}
	/**
	 * Method for user logout
	 */
	public void logout() {
        DataRepository.logout();
	}
	/**
	 * Update user profile.
	 * 
	 * @param name         New user name 
	 * @param email        New email address
	 * @param password     New user password
	 * @param isResearcher New researcher flag
	 * @return true if the profile is successfully updated, otherwise false
	 */
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
	/**
	 * Check the validity of the email format.
	 * 
	 * @param email Email to be validated.
	 * @return true if the format is correct, otherwise false.
	 */
    private boolean isValidEmail(String email) {
        // Проверка формата email с использованием регулярного выражения
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
    /**
     * Create a new order by the user.
     *
     * @param problemText Description of the problem for which the order is created.
     */
    public void createOrder(String problemText) {
    	Order order = new Order(problemText, Status.CREATED);
        DataRepository.addOrder(order);
    }
    /**
     * Create a log record for the user's actions.
     *
     * @param text Text of the log record.
     */
    public void createLogRecord(String text){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        LogRecord logRecord = new LogRecord(this.userId, formattedDateTime, text);
        LogsSettings.addLogRecord(logRecord);
    }
    /**
     * View news.
     */
    public void viewNews() {
        Vector<News> news = DataRepository.getNews();
        for (News n : news) {
            System.out.println(n);
        }
    }
    /**
     * Send a message to another user.
     *
     * @param receiver ID of the message recipient.
     * @param content  Message content.
     */
    public void sendMessage(int receiver, String content) {
        Message message = new Message(this.userId, receiver, content);
        DataRepository.addMessage(message);
    }
    /**
     * View user messages.
     */
    public void viewMessages() {
        Vector<Message> messages = DataRepository.getMessages();
        for (Message m : messages) {
            System.out.println(m);
        }
    }
    /**
     * Overridden method for comparing users.
     *
     * @param obj Object for comparison.
     * @return true if the users are identical, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return userId == other.userId;
    }
    /**
     * Overridden method to represent the User object as a string.
     *
     * @return String representation of the User object.
     */
    @Override
    public String toString() {
        return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
            + ", isResearcher=" + isResearcher + "]";
    }
}
