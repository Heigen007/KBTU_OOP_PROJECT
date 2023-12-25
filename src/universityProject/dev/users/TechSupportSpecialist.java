/**
 * The TechSupportSpecialist class represents a technical support specialist in the university project system,
 * extending the functionality provided by the base Employee class.
 *
 * @version 1.0
 * @author Zhanibek
 */
package universityProject.dev.users;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        createLogRecord("Tech-support specialist has been created");

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
        createLogRecord("Tech-support specialist viewed orders");
    }
    /**
     * Mark an order as solved.
     *
     * @param order The order to solve.
     */
    public void solveOrder(Order order) {
        order.setStatus(Status.SOLVED);
        createLogRecord("Tech-support specialist solved order "+ "(" + order.getOrderId() + ")");
    }

    public void createLogRecord(String text){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        universityProject.dev.logs.LogRecord logRecord = new universityProject.dev.logs.LogRecord(this.getUserId(), formattedDateTime, text);
        universityProject.dev.logs.LogsSettings.addLogRecord(logRecord);
    }


    /**
     * Reject an order.
     *
     * @param order The order to reject.
     */
    public void rejectOrder(Order order) {
        order.setStatus(Status.REJECTED);
        createLogRecord("Tech-support specialist rejected order" + " (" + order.getOrderId() + ")");
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