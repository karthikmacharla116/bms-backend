package com.bms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dto.LoginDto;
import com.bms.entity.Student;
import com.bms.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class StudentController {

	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@GetMapping("/students/{id}")
	public Student getStudentDetails(@PathVariable("id") int id) {
		logger.info(" /students/{} api called ", id);
		return studentService.getStudentDetailsById(id);
	}

	@PostMapping("/students/login")
	public ResponseEntity<String> facultyLogin(@RequestBody LoginDto loginDto) throws JsonProcessingException {
		logger.info(" /students/login api called with credentials {}", loginDto);
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(studentService.validateStudentLogin(loginDto));
		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

	@PostMapping("/students/register")
	public ResponseEntity<String> addStudent(@RequestBody Student student) throws JsonProcessingException {
		logger.info(" /students/register api called with details {}", student);
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(studentService.addStudentDetails(student));
		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

}
