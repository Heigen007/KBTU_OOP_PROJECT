package universityProject.dev.academicEntities;

import universityProject.dev.dataRepo.DataRepository;

import java.util.Vector;
import universityProject.dev.users.*;

/**
 * @author Asyl
 * @version 18.12.2023
 * The Journal class represents a journal within the academic entities of the university.
 * It contains information such as the journal ID, news items, and subscribers.
 */
public class Journal {

    /** The unique identifier for the journal. */
    private int journalId;

    /** The IDs of the news items in the journal. */
    private Vector<Integer> news;

    /** The IDs of the subscribers to the journal. */
    private Vector<Integer> subscribers;

    /**
     * Default constructor for the Journal class.
     * Initializes the journal with a unique ID and empty lists for news items and subscribers.
     */
    public Journal() {
        this.journalId = DataRepository.getNextId();
        this.news = new Vector<>();
        this.subscribers = new Vector<>();
    }

    /**
     * Retrieves the journal ID.
     *
     * @return The journal ID.
     */
    public int getJournalId() {
        return journalId;
    }

    /**
     * Retrieves the news items in the journal.
     *
     * @return A vector containing the news items in the journal.
     */
    public Vector<News> getNews() {
        Vector<News> newsTmp = new Vector<>();
        for (Integer newsId : news) {
            News newsItem = DataRepository.getNewsById(newsId);
            if (newsItem != null) {
                newsTmp.add(newsItem);
            }
        }
        return newsTmp;
    }

    /**
     * Retrieves the subscribers to the journal.
     *
     * @return A vector containing the subscribers to the journal.
     */
    public Vector<Student> getSubscribers() {
        Vector<Student> students = new Vector<>();
        for (Integer studentId : subscribers) {
            Student student = DataRepository.getStudentById(studentId);
            if (student != null) {
                students.add(student);
            }
        }
        return students;
    }

    /**
     * Adds a subscriber to the journal.
     *
     * @param subscriber The ID of the subscriber to be added.
     */
    public void addSubscriber(int subscriber) {
        subscribers.add(subscriber);
    }

    /**
     * Adds a news item to the journal and notifies subscribers.
     *
     * @param newsItem The ID of the news item to be added.
     */
    public void addNews(int newsItem) {
        news.add(newsItem);
        notifySubscribers(newsItem);
    }

    /**
     * Notifies subscribers about a new news item.
     *
     * @param newsItem The ID of the news item to notify subscribers about.
     */
    private void notifySubscribers(int newsItem) {
        for (int studentId : subscribers) {
            Student student = findStudentById(studentId);
            if (student != null) {
                student.update(newsItem);
            }
        }
    }

    /**
     * Finds a student by their ID.
     *
     * @param studentId The ID of the student to find.
     * @return The found student or null if not found.
     */
    private Student findStudentById(int studentId) {
        for (Student student : DataRepository.getStudents()) {
            if (student.getUserId() == studentId) {
                return student;
            }
        }
        return null;
    }

    /**
     * Checks if two Journal objects are equal based on their journal ID.
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
        Journal other = (Journal) obj;
        return journalId == other.journalId;
    }

    /**
     * Generates a string representation of the Journal object.
     *
     * @return A string representation of the Journal object.
     */
    @Override
    public String toString() {
        return "Journal [journalId=" + journalId + ", news=" + news + ", subscribers=" + subscribers + "]";
    }
}

