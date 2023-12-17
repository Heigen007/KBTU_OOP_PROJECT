package universityProject.dev.users;

public class Employee extends User {
    public Employee() {
		super();
	}

	public Employee(String name, String email, String password, Boolean isReseacher) {
		super(name, email, password, isReseacher);
	}

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}