package com.sanjay.student.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sanjay.student.model.Student;

public class FileUtil {
	public static void saveToFile(List<Student> studentList, String fileName) {
		try (FileWriter writer = new FileWriter(fileName)) {
			for (Student s : studentList) {
				writer.write(s.getId() + "," + s.getName() + "," + s.getAge() + "\n");
			}
		} catch (IOException e) {
			System.out.println("Error writing to file:" + e.getMessage());
		}
	}
	
	public static List<Student> loadFromFile(String fileName){
		List<Student> students=new ArrayList<>();
		try(BufferedReader reader=new BufferedReader(new FileReader(fileName))){
			
		String line;
		while((line=reader.readLine()) !=null) {
			String[] data=line.split(",");
			int id=Integer.parseInt(data[0]);
			String name=data[1];
			int age=Integer.parseInt(data[2]);
			students.add(new Student(id,name,age));
		}
		} catch (IOException e) {
			System.out.println("Error reading from file "+ e.getMessage());
		}
		return students;
	}

}
