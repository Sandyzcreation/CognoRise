package studentCourseRegistration;

import java.util.ArrayList;
import java.util.Scanner;

//Main class to manage the registration system
public class CourseRegistrationSystem {

	 private ArrayList<Course> courses;
	
	 public CourseRegistrationSystem() {
	     courses = new ArrayList<>();
	     
	     // Sample courses
	     courses.add(new Course("CS101", "Introduction to Computer Science", "Learn the basics of programming.", 2, "Mon/Wed 10-11 AM"));
	     courses.add(new Course("CS102", "Data Structures", "Introduction to data structures.", 3, "Tue/Thu 1-2 PM"));
	     courses.add(new Course("CS103", "Algorithms", "Study algorithms and complexity.", 1, "Mon/Wed 2-3 PM"));
	     
	     // Add more courses as needed
	 }
	
	 public void displayAvailableCourses() {
	     System.out.println("Available Courses:");
	     
	     for (Course c : courses) {
	         System.out.println(c);
	     }
	     
	     System.out.println();
	 }
	
	 public static void main(String[] args) {
	     Scanner scanner = new Scanner(System.in);
	     
	     CourseRegistrationSystem registrationSystem = new CourseRegistrationSystem();
	     
	     System.out.print("Enter your Student ID: ");
	     String studentID = scanner.nextLine();
	     
	     System.out.print("Enter your Name: ");
	     String studentName = scanner.nextLine();
	     
	     Student student = new Student(studentID, studentName);
	     
	     while (true) {
	         registrationSystem.displayAvailableCourses();
	         
	         System.out.println("1. Register for a Course");
	         System.out.println("2. Drop a Course");
	         System.out.println("3. View Registered Courses");
	         System.out.println("4. Exit");
	         System.out.print("Choose an option: ");
	         
	         int choice = scanner.nextInt();
	         scanner.nextLine(); // Consume newline
	         
	         switch (choice) {
	             case 1:
	                 System.out.print("Enter the Course Code to register: ");
	                 String codeToRegister = scanner.nextLine();
	                 boolean foundToRegister = false;
	
	                 for (Course c : registrationSystem.courses) {
	                     if (c.getCourseCode().equalsIgnoreCase(codeToRegister)) {
	                         student.registerCourse(c);
	                         foundToRegister = true;
	                         break;
	                     }
	                 }
	                 
	                 if (!foundToRegister) {
	                     System.out.println("Course not found.");
	                 }
	                 break;
	
	             case 2:
	                 System.out.print("Enter the Course Code to drop: ");
	                 String codeToDrop = scanner.nextLine();
	                 boolean foundToDrop = false;
	
	                 for (Course c : registrationSystem.courses) {
	                     if (c.getCourseCode().equalsIgnoreCase(codeToDrop)) {
	                         student.dropCourse(c);
	                         foundToDrop = true;
	                         break;
	                     }
	                 }
	                 
	                 if (!foundToDrop) {
	                     System.out.println("You are not registered for that course.");
	                 }
	                 break;
	
	             case 3:
	                 student.displayRegisteredCourses();
	                 break;
	
	             case 4:
	                 System.out.println("Exiting...");
	                 scanner.close();
	                 return;
	
	             default:
	                 System.out.println("Invalid option. Please try again.");
	         }
	         
	         System.out.println(); // New line for better readability
	    }
	 }
}
	
	
