package com.jamp.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jamp.app.domain.Course;
import com.jamp.app.domain.Student;



//@Controller
@RestController
//@RequestMapping
public class StudentController {
	
	//@ResponseBody
//	@RequestMapping(value = "/getstudent/{id}/{name}",
//		method = RequestMethod.GET,
//		produces={"application/json", "application/xml"})
	
	@GetMapping(value = "/getstudent/{id}/{name}", produces={"application/json", "application/xml"})
	public Student getStudent(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") final int id,
			@PathVariable("name") final String name) {
		
		// Create a new student object and return it
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
		Student student = new Student(id, name, dateFormatter.format(new Date()));
		
		List<Course> cources = student.getCourses();
		cources.add(new Course("Math", 15));
		cources.add(new Course("Politics", 100));
		
		return student;
	}
	
	
	
	//@ResponseBody
//	@RequestMapping(value = "/echostudent",
//		method = RequestMethod.POST,
//		produces={"application/json", "application/xml"},
//		consumes={"application/json", "application/xml"})
	
	@PostMapping(value = "/echostudent", produces={"application/json", "application/xml"}, consumes={"application/json", "application/xml"})
	public Student echoStudent(@RequestBody Student student,
			HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(student);
		
		// Just echo the same student back
		return student;
	}
}
