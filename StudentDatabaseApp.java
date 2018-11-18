package studentDatabaseApp;

import java.util.Scanner;



public class StudentDatabaseApp {

	public static void main(String[] args) {
		
		// Ask how many students we want to add
		System.out.println("Enter number of new students to enroll: ");
		Scanner in = new Scanner(System.in);
		int numOfStudents = in.nextInt();
		Student[] students = new Student[numOfStudents];
		
		// Create n number of new Students
		for (int i = 0; i < numOfStudents; i++) {
			students[i] = new Student();
			students[i].menu();
		}
		for (int i = 0; i < numOfStudents; i++) {
			System.out.println(students[i]);
		}
	}

}
