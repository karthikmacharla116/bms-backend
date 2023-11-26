package com.bms.service;

import com.bms.dto.LoginDto;
import com.bms.dto.StudentDto;
import com.bms.entity.Student;

public interface StudentService {
	
	Student getStudentDetailsById(int id);

	String validateStudentLogin(LoginDto loginDto);

	String addStudentDetails(Student student);
	
}
