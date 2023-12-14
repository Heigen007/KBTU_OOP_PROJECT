package universityProject.dev.academicEntities;

import universityProject.dev.dataRepo.DataRepository;

public class Lesson {

    private int lessonID;
    private int orderNumber;
    private int course;
    private String topic;
    private LessonType type;

    public Lesson() {
    }

    public Lesson(int orderNumber, int course, String topic, LessonType type) {
        this.lessonID = DataRepository.getNextId();
        this.orderNumber = orderNumber;
        this.course = course;
        this.topic = topic;
        this.type = type;
    }

    public int getLessonID() {
        return this.lessonID;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public Course getCourse() {
        return DataRepository.getCourseById(this.course);
    }

    public String getTopic() {
        return this.topic;
    }

    public LessonType getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Lesson other = (Lesson) obj;
        return lessonID == other.lessonID;
    }
}
