package com.sanjay.student.service;

import java.util.Iterator;
import java.util.List;

import com.sanjay.student.model.Student;
import com.sanjay.student.util.FileUtil;

public class StudentService {
	private static final String FILE_NAME = "Student.txt";

	public StudentService() {
		studentList = FileUtil.loadFromFile(FILE_NAME);
	}

	//private ArrayList<Student> studentList = new ArrayList<>();
	private List<Student> studentList;

	public boolean addStudent(Student s) {

		studentList.add(s);
		FileUtil.saveToFile(studentList, FILE_NAME);
		return true;
	}

	public void viewAll() {
		for (Student s : studentList) {
			s.display();
		}
	}

	public Student searchById(int id) {
		for (Student s : studentList) {
			if (s.getId() == id) {
				return s;
			}

		}
		return null;

	}

	public boolean deleteById(int id) {
		Iterator<Student> itr = studentList.iterator();
		while (itr.hasNext()) {
			Student s = itr.next();
			if (s.getId() == id) {
				itr.remove();
				FileUtil.saveToFile(studentList, FILE_NAME);
				return true;
			}
		}
		return false;
	}

	public boolean updateStudentById(int id, String newName, int newAge) {
		for (Student s : studentList) {
			if (s.getId() == id) {
				s.setName(newName);
				s.setAge(newAge);
				FileUtil.saveToFile(studentList, FILE_NAME);
				return true;
			}

		}
		return false;
	}
}
