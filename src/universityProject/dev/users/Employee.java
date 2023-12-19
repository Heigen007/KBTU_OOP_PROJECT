/**
 * The Employee class represents an employee in the university project system,
 * extending the functionality provided by the base User class.
 * @version 1.0
 * @author Zhanibek
 */
package universityProject.dev.users;

public class Employee extends User {
	/**
     * Default constructor for creating an Employee object.
     */
    public Employee() {
		super();
	}
    /**
     * Constructor for creating an Employee object with specified parameters.
     *
     * @param name        The name of the employee.
     * @param email       The email address of the employee.
     * @param password    The password for the employee.
     * @param isResearcher A boolean indicating whether the employee is a researcher.
     */
	public Employee(String name, String email, String password, Boolean isReseacher) {
		super(name, email, password, isReseacher);
	}
	/**
     * Overrides the equals method of the base class to compare Employee objects.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}