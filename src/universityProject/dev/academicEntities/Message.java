package universityProject.dev.academicEntities;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.users.User;


public class Message {

    private int messageID;
    private int senderUser;
    private int receiverUser;
    private String content;

    public Message() {
    }

    public Message(int senderUser, int receiverUser, String content) {
        this.messageID = DataRepository.getNextId();
        this.senderUser = senderUser;
        this.receiverUser = receiverUser;
        this.content = content;
    }

    public int getMessageID() {
        return this.messageID;
    }

    public User getSenderUser() {
        return DataRepository.getUserById(this.senderUser);
    }

    public User getReceiverUser() {
        return DataRepository.getUserById(this.receiverUser);
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Message other = (Message) obj;
        return messageID == other.messageID;
    }
}
