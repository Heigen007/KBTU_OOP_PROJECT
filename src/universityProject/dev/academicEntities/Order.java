package universityProject.dev.academicEntities;

import universityProject.dev.dataRepo.DataRepository;

/**
 * @author Asyl
 * @version 18.12.2023
 * The Order class represents a request or problem submitted by a user.
 * It contains information such as the order ID, problem text, and status.
 */
public class Order {

    /** The unique identifier for the order. */
    private int orderId;

    /** The text describing the problem or request. */
    private String problemText;

    /** The status of the order. */
    private Status status;

    /** Default constructor for the Order class. */
    public Order() {
    }

    /**
     * Constructs an Order object with specified parameters.
     *
     * @param problemText The text describing the problem or request.
     * @param status      The initial status of the order.
     */
    public Order(String problemText, Status status) {
        this.orderId = DataRepository.getNextId();
        this.problemText = problemText;
        this.status = status;
    }

    /**
     * Retrieves the order ID.
     *
     * @return The order ID.
     */
    public int getOrderId() {
        return this.orderId;
    }

    /**
     * Retrieves the text describing the problem or request.
     *
     * @return The text describing the problem or request.
     */
    public String getProblemText() {
        return this.problemText;
    }

    /**
     * Retrieves the status of the order.
     *
     * @return The status of the order.
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * Sets the status of the order.
     *
     * @param status The new status of the order.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Checks if two Order objects are equal based on their order ID.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        return orderId == other.orderId;
    }

    /**
     * Generates a string representation of the Order object.
     *
     * @return A string representation of the Order object.
     */
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", problemText=" + problemText + ", status=" + status + "]";
    }
}
