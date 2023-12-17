package universityProject.dev.academicEntities;

import universityProject.dev.dataRepo.DataRepository;

public class Lesson {

    private int lessonID;
    private int course;
    private String topic;
    private LessonType type;

    public Lesson() {
    }

    public Lesson( int course, String topic, LessonType type) {
        this.lessonID = DataRepository.getNextId();
        this.course = course;
        this.topic = topic;
        this.type = type;
    }

    public int getLessonID() {
        return this.lessonID;
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

    @Override
    public String toString() {
        return "Lesson [lessonID=" + lessonID + ", course=" + course + ", topic=" + topic + ", type=" + type + "]";
    }
}
