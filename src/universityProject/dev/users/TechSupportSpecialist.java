/**
 * The TechSupportSpecialist class represents a technical support specialist in the university project system,
 * extending the functionality provided by the base Employee class.
 *
 * @version 1.0
 * @author Zhanibek
 */
package universityProject.dev.users;

import java.util.Vector;

import universityProject.dev.academicEntities.Order;
import universityProject.dev.academicEntities.Status;
import universityProject.dev.dataRepo.DataRepository;

public class TechSupportSpecialist  extends Employee {
	/**
     * Constructor for creating a TechSupportSpecialist object with specified parameters.
     *
     * @param name     The name of the technical support specialist.
     * @param email    The email address of the technical support specialist.
     * @param password The password for the technical support specialist.
     */
	public TechSupportSpecialist(String name, String email, String password) {
		super(name, email, password, false);
	}
	/**
     * View all orders currently in the system.
     */
    public void viewOrders() {
        Vector<Order> orders = DataRepository.getOrders();
        System.out.println("Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
    /**
     * Mark an order as solved.
     *
     * @param order The order to solve.
     */
    public void solveOrder(Order order) {
        order.setStatus(Status.SOLVED);
    }
    /**
     * Reject an order.
     *
     * @param order The order to reject.
     */
    public void rejectOrder(Order order) {
        order.setStatus(Status.REJECTED);
    }
    /**
     * Overrides the equals method of the base class to compare TechSupportSpecialist objects.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}