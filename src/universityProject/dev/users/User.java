package universityProject.dev.users;


/**
* @generated
*/
public class User {
    
	private Integer userId;
	private String name;
	private String email;
	private String password;
	private Boolean isResearcher;
	
	public User() {
		
	}
	
	public User(Integer userId, String name, String email, String password, Boolean isReseacher) {
		this.email = email;
		this.isResearcher = isReseacher;
		this.name = name;
		this.password = password;
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void login(String enteredName, String enteredPassword) {
	    // Проверка наличия введенных учетных данных
	    if (enteredName != null && enteredPassword != null) {
	        // Проверка совпадения учетных данных
	        if (enteredName.equals(name) && enteredPassword.equals(password)) {
	            handleSuccessfulLogin();
	        } else {
	            handleFailedLogin();
	        }
	    } else {
	        // Обработка случая, когда введены некорректные данные
	        handleFailedLogin();
	    }
	}

	private void handleSuccessfulLogin() {
	    // Вывод сообщения в зависимости от роли пользователя
	    if (this instanceof Student) {
	        System.out.println("Student logged in");
	    } else if (this instanceof Teacher) {
	        System.out.println("Teacher logged in");
	    } else if (this instanceof Admin) {
	        System.out.println("Admin logged in");
	    }
	}

	private void handleFailedLogin() {
	    // Обработка случая, когда введены неверные учетные данные
	    System.out.println("Login failed");
	}
	
	public void logout() {
		System.out.println("Logout");
	}
	
	public boolean updateProfile(Integer userId, String name, String email, String password) {
        if (userId == null || name == null || email == null || password == null) {
            // Обработка случая, когда один из параметров равен null
            return false;
        }

        // Валидация email и других данных
        if (!isValidEmail(email)) {
            // Обработка случая с некорректным email
            return false;
        }

        // Логика обновления профиля пользователя
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;

        // Возвращаем true в случае успешного обновления
        return true;
    }

    private boolean isValidEmail(String email) {
        // Простая проверка формата email с использованием регулярного выражения
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
//    protected List<String> messages = new ArrayList<>();
//    // Метод для получения сообщений от других пользователей
//    public void receiveMessage(String message) {
//        messages.add(message);
//    }
    
    public void createLogRecord();
    
    public void createOrder();
    
    
}
