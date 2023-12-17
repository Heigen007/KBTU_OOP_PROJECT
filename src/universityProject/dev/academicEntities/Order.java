package universityProject.dev.academicEntities;

import universityProject.dev.dataRepo.DataRepository;

public class Order {

    private int orderId;
    private String problemText;
    private Status status;

    public Order() {
    }

    public Order(String problemText, Status status) {
        this.orderId = DataRepository.getNextId();
        this.problemText = problemText;
        this.status = status;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public String getProblemText() {
        return this.problemText;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        return orderId == other.orderId;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", problemText=" + problemText + ", status=" + status + "]";
    }
}