package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentServices {
	String addStudent(Student s);
	Student getStudent(String roll);
	List<Student> getAllStudent();
	String updateStudent(Student s);
	String deleteStudent(String roll);
}
