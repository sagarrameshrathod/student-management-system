package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentServices;

@Controller
public class StudentController {
	StudentServices ss;
	public StudentController(StudentServices ss) {
		super();
		this.ss = ss;
	}

	@GetMapping("/home")
	public String homeStudent() {
		return "index";
	}
	@GetMapping("/viewIn")
	public String getStudent() {
		return "viewInfo";
	}
	@GetMapping("/addStud")
	public String addtStudent() {
		return "register";
	}
	@GetMapping("/updStud")
	public String updatetStudent() {
		return "updateInfo";
	}
	@GetMapping("/delStud")
	public String deleteStudent() {
		return "remove";
	}

	@PostMapping("/addStudent")
	public String addStudent(@RequestParam("roll") String roll, @RequestParam("name") String name, @RequestParam("branch") String branch) {
		Student s = new Student(roll,name, branch);
		ss.addStudent(s);
		return "done";
	}


	@PutMapping("/update")
	public String updateStudent(@RequestParam("roll") String roll, @RequestParam("name") String name, @RequestParam("branch") String branch) {
			Student student = ss.getStudent(roll);
			if (student != null) {
				student.setName(name);
				student.setBranch(branch);
				ss.updateStudent(student);
				return "done";
			} else {
				return "error";
			}

	}
	@GetMapping("/showStudent")
	public String getStudent(@RequestParam("roll") String roll, Model model) {
		Student st = ss.getStudent(roll);
		if (st != null) {
			model.addAttribute("student", st);
			return "showInfo";
		} else {
			return "error";
		}
	}


	@PostMapping("/delete")
	public String deleteStudent(@RequestParam("roll") String roll, Model model) {
			Student st = ss.getStudent(roll);
			if (st != null) {
				ss.deleteStudent(roll);
				return "done";
			} else {
				return "error";
			}
	}
}
