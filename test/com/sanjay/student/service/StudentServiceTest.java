package com.sanjay.student.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sanjay.student.model.Student;

public class StudentServiceTest {
	private StudentService service;

	@BeforeEach
	void setUp() {
		service = new StudentService();

	}

	@Test
	void testAddStudent() {
		// Student s=new Student(101,"sanjay",32);
		Student s = new Student(100, "sanjay", 32);
		boolean result = service.addStudent(s);
		assertTrue(result);

	}

	@Test
	void testUpdateStudentById() {
		Student s = new Student(1, "Rahul", 21);
		service.addStudent(s);

		Student updated = new Student(1, "Rohan", 22);
		boolean result = service.updateStudentById(1, "Rohan", 22);

		assertTrue(result); // Update should be successful

		// Optional: Verify values are updated
		Student updatedStudent = service.searchById(1);
		assertEquals("Rohan", updatedStudent.getName());
		assertEquals(22, updatedStudent.getAge());
	}

	@Test
	void testdeleteStudentById() {
		Student s = new Student(1, "Sanjay", 30);
		service.addStudent(s);
		boolean result = service.deleteById(1);
		assertTrue(result);
		// assertEquals(0,service.searchById(0));

	}

	@Test
	void testGetStudentById() {
		Student s = new Student(1, "abc", 20);
		boolean result = service.addStudent(s);
		assertNotNull(s);

	}

//	@Test
//	void testViewAll() {
//		service.addStudent(new Student(1, "Rahul", 21));
//		service.addStudent(new Student(2, "Rohan", 22));
//
//		List<Student> students = service.viewAll();
//
//		assertEquals(0, students.size());
//		assertEquals("Rahul", students.get(0).getName());
//		assertEquals("Rohan", students.get(1).getName());
//
//	}

};