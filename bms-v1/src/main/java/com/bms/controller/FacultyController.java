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
import com.bms.entity.Faculty;
import com.bms.service.FacultyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FacultyController {

	Logger logger = LoggerFactory.getLogger(FacultyController.class);

	@Autowired
	private FacultyService facultyService;

	@GetMapping("/faculties/{facultyId}")
	public Faculty getFacultyDetails(@PathVariable("facultyId") int facultyId) {
		logger.info(" /faculties/{} api called ", facultyId);
		return facultyService.getFacultyDetailsById(facultyId);
	}

	@PostMapping("/faculties/login")
	public ResponseEntity<String> facultyLogin(@RequestBody LoginDto loginDto) throws JsonProcessingException {
		logger.info(" /faculties/login api called with credentials {}", loginDto);
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(facultyService.validateFacultyLogin(loginDto));
		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

	@PostMapping("/faculties/register")
	public ResponseEntity<String> addFaculty(@RequestBody Faculty faculty) throws JsonProcessingException {
		logger.info(" /faculties/register api called with details {}", faculty);
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(facultyService.addFacultyDetails(faculty));
		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

}
