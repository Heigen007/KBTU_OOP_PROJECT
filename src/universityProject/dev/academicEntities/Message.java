package universityProject;

public class Message {

    private int messageID;
    private User senderUser;
    private User receiverUser;
    private String content;

    // Конструктор без параметров
    public Message() {
    }

    // Конструктор с параметрами
    public Message(int messageID, User senderUser, User receiverUser, String content) {
        this.messageID = messageID;
        this.senderUser = senderUser;
        this.receiverUser = receiverUser;
        this.content = content;
    }

    // Геттеры и сеттеры

    public int getMessageID() {
        return this.messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public User getSenderUser() {
        return this.senderUser;
    }

    public void setSenderUser(User senderUser) {
        this.senderUser = senderUser;
    }

    public User getReceiverUser() {
        return this.receiverUser;
    }

    public void setReceiverUser(User receiverUser) {
        this.receiverUser = receiverUser;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Операции

}
