package studentCourseRegistration;
//import java.util.ArrayList;
//import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int registeredStudents;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.registeredStudents = 0; // Initially no students are registered
        this.schedule = schedule;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public String getSchedule() {
        return schedule;
    }

    public boolean registerStudent() {
        if (registeredStudents < capacity) {
            registeredStudents++;
            return true; // Registration successful
        }
        return false; // Registration failed due to full capacity
    }

    public void dropStudent() {
        if (registeredStudents > 0) {
            registeredStudents--;
        }
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + ", Title: " + title + ", Description: " + description +
                ", Capacity: " + capacity + ", Registered: " + registeredStudents + ", Schedule: " + schedule;
    }
}


