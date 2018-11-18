package studentDatabaseApp;

import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;

	// Constructor: prompt user to enter student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student first name: ");
		this.firstName = in.nextLine();

		System.out.println("Enter student last name: ");
		this.lastName = in.nextLine();

		System.out.println("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level: ");
		this.gradeYear = in.nextInt();

		setStudetId();
	}

	// Generate an ID
	private void setStudetId() {
		id++;
		studentID = gradeYear + "" + id;
		System.out.println(studentID);
	}

	public void menu() {
		Scanner in = new Scanner(System.in);
		System.out.println("1 - Enroll new courses\n2 - View Balance\n3 - Pay tuition\n4 - Exit/Save Student info");
		int menuChoise = in.nextInt();
		if (menuChoise == 1) {
			enroll();
		}
		else if (menuChoise == 2) {
			viewBalane();
		}
		else if (menuChoise == 3) {
			System.out.println("How much you would like to pay?");
			int payment = in.nextInt();
			payTuition(payment);
		}
		else if (menuChoise == 4) {
			System.out.println("Student info saved\n");
			showInfo();
		}else {
			menu();
		}
	}
	
	
	// Enroll in courses
	private void enroll() {
		do {
			System.out.print("Enter the course to enroll (Q to quit) ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q")) {
				courses = courses + "\n" + course;
				tuitionBalance += costOfCourse;
			} else {
				break;
			}
		} while (1 != 0);

		System.out.println("ENROLLED IN: " + courses);
		viewBalane();
	}
	
	//View Balance
	private void viewBalane() {
		System.out.println("Your balance is: $" + tuitionBalance);
		Scanner in = new Scanner(System.in);
		System.out.println("Back to the menu press (B)");
		String back = in.nextLine();
		if (back.equals("B") || back.equals("b")) {
			menu();
		}
	}
	
	// Pay tuition
	private void payTuition(int payment) {
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalane();
	}
	// Show status
	
	private String showInfo() {
		return "Name: " + firstName + " " + " " + lastName +
				"\nCourses Enrolled: " + courses +
				"\nBalance: $" + tuitionBalance + "\n";
	}
	public String toString() {
		return showInfo();
	}
}
