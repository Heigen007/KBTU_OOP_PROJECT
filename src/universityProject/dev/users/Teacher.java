package universityProject;


import universityProject.enums.TeacherTitle;

import java.util.ArrayList;

public class Teacher  extends Employee {

    /**
     * ArrayList for cunducting rate, rate putted by Student(method - putRateToTeacher())
     */
    private ArrayList<Double> rates;
    private Course courses;
    private TeacherTitle title;

    private Course getCourses() {
        return this.courses;
    }

    private void setCourses(Course courses) {
        this.courses = courses;
    }

    private TeacherTitle getTitle() {
        return this.title;
    }

    private void setTitle(TeacherTitle title) {
        this.title = title;
    }

    public double getAverageRate(){
        if (this.rates.isEmpty()) {
            return 0; // Return null if the vector is empty
        }

        double total = 0;
        for (double mark : this.rates) {
            total += mark;
        }

        return total / this.rates.size();
    }
    public Course viewCourses() {
        //TODO
        return null;
    }


    public void addRate(double mark) {
        rates.add(mark);
    }
}
