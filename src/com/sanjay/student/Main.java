package com.sanjay.student;

import java.util.Scanner;

import com.sanjay.student.model.Student;
import com.sanjay.student.service.StudentService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//main java file
		StudentService service = new StudentService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(
					"\n1. add Student\n2. view all\n3.Search by Id\n4. Delete by Id\n5. Update By Id \n6. Exit");
			System.out.println("Enter choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter ID");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Name:");
				String name = sc.nextLine();
				System.out.println("Eneter Age:");
				int age = sc.nextInt();
				Student s = new Student(id, name, age);
				service.addStudent(s);
				break;

			case 2:
				service.viewAll();
				break;

			case 3:
				System.out.print("Enter d for search:");
				int sid = sc.nextInt();
				Student result = service.searchById(sid);
				if (result != null)
					result.display();
				else
					System.out.println("Student not found");
				break;

			case 4:
				System.out.print("Enter ID to delete: ");
				int did = sc.nextInt();
				if (service.deleteById(did))
					System.out.println("Deleted successfully.");
				else
					System.out.println("Student not found.");
				break;
			case 5:
				System.out.print("Enter Id to update: ");
				int uid = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter new name: ");
				String uname = sc.nextLine();
				System.out.print("Eneter new age: ");
				int newage = sc.nextInt();

				if (service.updateStudentById(uid, uname, newage)) {
					System.out.println("Student update successfully!");
				} else {
					System.out.println("Student not found");
				}
				break;

			case 6:
				System.out.println("Thanks for using the system.");
				return;

			default:
				System.out.println("Invalid choice!");

			}
		}

	}

}
