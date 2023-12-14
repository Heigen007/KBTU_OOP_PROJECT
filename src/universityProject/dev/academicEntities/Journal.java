package universityProject.dev.academicEntities;

import universityProject.dev.dataRepo.DataRepository;

import java.util.Vector;
import universityProject.dev.users.*;

public class Journal {

    private int journalId;
    private Vector<Integer> news;
    private Vector<Integer> subscribers;

    public Journal() {
        this.journalId = DataRepository.getNextId();
        this.news = new Vector<>();
        this.subscribers = new Vector<>();
    }

    public int getJournalId() {
        return journalId;
    }

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

    public void addSubscriber(int subscriber) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Journal other = (Journal) obj;
        return journalId == other.journalId;
    }
}
