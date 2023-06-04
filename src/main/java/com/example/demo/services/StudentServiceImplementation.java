package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentServices{
	StudentRepository srepo;
	public  StudentServiceImplementation(StudentRepository srepo) {
		this.srepo = srepo;
	}
	@Override
	public String addStudent(Student s) {
		srepo.save(s);
		return "Student added!!";
	}
	@Override
	public String updateStudent(Student s) {
		srepo.save(s);
		return "Student upadate!!";
	}
	@Override
	public Student getStudent(String roll) {
		Student st = srepo.findById(roll).get();
		return st;
	}
	@Override
	public List<Student> getAllStudent() {
		List<Student> list = srepo.findAll();
		return list;
	}
	@Override
	public String deleteStudent(String roll) {
		srepo.deleteById(roll);
		return "Student deleted!!";
	}
}
