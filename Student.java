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

		System.out.println(firstName + " " + lastName + "\nGrade year: " + gradeYear + "\nStudent ID: " + studentID);

	}

	// Generate an ID
	private void setStudetId() {
		id++;
		studentID = gradeYear + "" + id;
	}

	public void menu() {
		Scanner in = new Scanner(System.in);
		System.out.println("1 - Enroll new courses\n2 - View Balance\n3 - Pay tuition\n4 - Show info");
		int menuChoise = in.nextInt();
		if (menuChoise == 1) {
			enroll();
		}
		else if (menuChoise == 2) {
			viewBalane();
		}
		else if (menuChoise == 3) {
			Scanner in2 = new Scanner(System.in);
			System.out.println("How much you would like to pay?");
			int payment = in2.nextInt();
			payTuition(payment);
		}
		else if (menuChoise == 4) {
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
		System.out.println("TUITION BALANCE: " + tuitionBalance);
		Scanner in3 = new Scanner(System.in);
		System.out.println("Back to the menu press (B)");
		String back = in3.nextLine();
		if (back.equals("B")) {
			menu();
		}
	}
	
	//View Balance
	private void viewBalane() {
		System.out.println("Your balance is: $" + tuitionBalance);
		Scanner in3 = new Scanner(System.in);
		System.out.println("Back to the menu press (B)");
		String back = in3.nextLine();
		if (back.equals("B")) {
			menu();
		}
	}
	
	// Pay tuition
	private void payTuition(int payment) {
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		Scanner in3 = new Scanner(System.in);
		System.out.println("Back to the menu press (B)");
		String back = in3.nextLine();
		if (back.equals("B")) {
			menu();
		}
	}
	// Show status
	private void showInfo() {
		System.out.println("Student: " + firstName + " " + lastName);
		System.out.println("Grade Year: " + gradeYear);
		System.out.println("Student ID: " + studentID);
		System.out.println("Courses enrolled: " + courses);
		System.out.println("Balance to pay: " + tuitionBalance);
		
		Scanner in3 = new Scanner(System.in);
		System.out.println("Back to the menu press (B)");
		String back = in3.nextLine();
		if (back.equals("B")) {
			menu();
		}
	}
}
