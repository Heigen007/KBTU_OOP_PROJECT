package universityProject.dev.academicEntities;

import java.util.Vector;
import universityProject.dev.users.*;

public class Journal {

    private int journalId;
    private Vector<int> news;
    private Vector<int> subscribers;

    public Journal(int journalId) {
        this.journalId = journalId;
        this.news = new Vector<>();
        this.subscribers = new Vector<>();
    }

    public int getJournalId() {
        return journalId;
    }

    public Vector<int> getNews() {
        return news;
    }

    public Vector<int> getSubscribers() {
        return subscribers;
    }

    public void addSubscriber(Observer subscriber) {
        subscribers.add(subscriber);
    }

    public void addNews(int newsItem) {
        news.add(newsItem);
        notifySubscribers(newsItem);
    }

    private void notifySubscribers(int newsItem) {
        for (int studentId : subscribers) {
            Student student = findStudentById(studentId);
            if (student != null) {
                student.update(newsItem);
            }
        }
    }

    private Student findStudentById(int studentId) {
        for (Student student : DataRepository.getStudents()) {
            if (student.getUserId() == studentId) {
                return student;
            }
        }
        return null;
    }
}
