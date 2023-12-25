/**
 * The UserDecorator class is an abstract class representing a decorator for user objects.
 * It allows for extending the functionality of user objects without modifying their code directly.
 *
 * @version 1.0
 * @author Zhanibek
 */
package universityProject.dev.users;

import java.io.Serializable;

import universityProject.dev.dataRepo.DataRepository;

public abstract class UserDecorator implements Serializable {
	/**
     * The identifier of the user being decorated.
     */
    protected Integer decoratedUser;
    /**
     * Default constructor.
     */
    public UserDecorator() {
    }
    /**
     * Parameterized constructor with the decorated user's identifier.
     *
     * @param decoratedUser The identifier of the user being decorated.
     */
    public UserDecorator(Integer decoratedUser) {
        this.decoratedUser = decoratedUser;
    }
    /**
     * Gets the decorated user object from the data repository.
     *
     * @return The decorated user object.
     */
    public User getDecoratedUser() {
        return DataRepository.getUserById(this.decoratedUser);
    }
    /**
     * Checks if this UserDecorator is equal to another object.
     *
     * @param obj The object to compare with this UserDecorator.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        UserDecorator other = (UserDecorator) obj;
        return decoratedUser == other.decoratedUser;
    }
}