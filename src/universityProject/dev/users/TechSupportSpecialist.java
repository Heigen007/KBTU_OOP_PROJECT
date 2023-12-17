package universityProject.dev.users;

import java.util.Vector;

import universityProject.dev.academicEntities.Order;
import universityProject.dev.academicEntities.Status;
import universityProject.dev.dataRepo.DataRepository;

public class TechSupportSpecialist  extends Employee {

	public TechSupportSpecialist(String name, String email, String password) {
		super(name, email, password, false);
	}

    public void viewOrders() {
        Vector<Order> orders = DataRepository.getOrders();
        System.out.println("Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void solveOrder(Order order) {
        order.setStatus(Status.SOLVED);
    }

    public void rejectOrder(Order order) {
        order.setStatus(Status.REJECTED);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}