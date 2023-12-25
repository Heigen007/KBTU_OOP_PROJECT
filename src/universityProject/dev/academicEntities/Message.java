package universityProject.dev.academicEntities;

import java.io.Serializable;

import universityProject.dev.dataRepo.DataRepository;
import universityProject.dev.users.User;

/**
 * @author Asyl
 * @version 18.12.2023
 * The Message class represents a communication message between users.
 * It contains information such as the message ID, sender user, receiver user, and content.
 */
public class Message implements Serializable {

    /** The unique identifier for the message. */
    private int messageID;

    /** The ID of the user who sent the message. */
    private int senderUser;

    /** The ID of the user who received the message. */
    private int receiverUser;

    /** The content of the message. */
    private String content;

    /** Default constructor for the Message class. */
    public Message() {
    }

    /**
     * Constructs a Message object with specified parameters.
     *
     * @param senderUser   The ID of the user who sent the message.
     * @param receiverUser The ID of the user who received the message.
     * @param content      The content of the message.
     */
    public Message(int senderUser, int receiverUser, String content) {
        this.messageID = DataRepository.getNextId();
        this.senderUser = senderUser;
        this.receiverUser = receiverUser;
        this.content = content;
    }

    /**
     * Retrieves the message ID.
     *
     * @return The message ID.
     */
    public int getMessageID() {
        return this.messageID;
    }

    /**
     * Retrieves the user who sent the message.
     *
     * @return The user who sent the message.
     */
    public User getSenderUser() {
        return DataRepository.getUserById(this.senderUser);
    }

    /**
     * Retrieves the user who received the message.
     *
     * @return The user who received the message.
     */
    public User getReceiverUser() {
        return DataRepository.getUserById(this.receiverUser);
    }

    /**
     * Retrieves the content of the message.
     *
     * @return The content of the message.
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Checks if two Message objects are equal based on their message ID.
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
        Message other = (Message) obj;
        return messageID == other.messageID;
    }

    /**
     * Generates a string representation of the Message object.
     *
     * @return A string representation of the Message object.
     */
    @Override
    public String toString() {
        return "Message [messageID=" + messageID + ", senderUser=" + senderUser + ", receiverUser=" + receiverUser
                + ", content=" + content + "]";
    }
}
