package universityProject;

public class Order {

    private int orderId;
    private String problemText;
    private Status status;

    // Конструктор без параметров
    public Order() {
    }

    // Конструктор с параметрами
    public Order(int orderId, String problemText, Status status) {
        this.orderId = orderId;
        this.problemText = problemText;
        this.status = status;
    }

    // Геттеры и сеттеры

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProblemText() {
        return this.problemText;
    }

    public void setProblemText(String problemText) {
        this.problemText = problemText;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Операции

}
