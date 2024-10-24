package studentCourseRegistration;

import java.util.ArrayList;

//Class to represent a Student
class Student {
 private String studentID;
 private String name;
 private ArrayList<Course> registeredCourses;

 public Student(String studentID, String name) {
     this.studentID = studentID;
     this.name = name;
     this.registeredCourses = new ArrayList<>();
 }

 public String getStudentID() {
     return studentID;
 }

 public String getName() {
     return name;
 }

 public void registerCourse(Course course) {
     if (course.registerStudent()) {
         registeredCourses.add(course);
         System.out.println("Successfully registered for " + course.getTitle());
     } else {
         System.out.println("Failed to register for " + course.getTitle() + ": Course is full.");
     }
 }

 public void dropCourse(Course course) {
     if (registeredCourses.remove(course)) {
         course.dropStudent();
         System.out.println("Successfully dropped " + course.getTitle());
     } else {
         System.out.println("You are not registered for " + course.getTitle());
     }
 }

 public void displayRegisteredCourses() {
     if (registeredCourses.isEmpty()) {
         System.out.println("No courses registered.");
         return;
     }
     
     System.out.println("Registered Courses:");
     for (Course c : registeredCourses) {
         System.out.println(c);
     }
 }
}

