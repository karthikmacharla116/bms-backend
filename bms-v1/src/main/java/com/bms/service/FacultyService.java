package com.bms.service;

import com.bms.dto.LoginDto;
import com.bms.entity.Faculty;

public interface FacultyService {

	Faculty getFacultyDetailsById(int facultyId);

	String validateFacultyLogin(LoginDto loginDto);

	String addFacultyDetails(Faculty faculty);
	
}
