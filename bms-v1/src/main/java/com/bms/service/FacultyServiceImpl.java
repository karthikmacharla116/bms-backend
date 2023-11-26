package com.bms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dto.LoginDto;
import com.bms.entity.Faculty;
import com.bms.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {
	
	@Autowired
	private FacultyRepository facultyRepository;

	@Override
	public Faculty getFacultyDetailsById(int facultyId) {
		
		Optional<Faculty> faculty = facultyRepository.findById(facultyId);
		
		if(faculty.isPresent()) {
			return faculty.get();
		}
		
		return new Faculty();
	}

	@Override
	public String validateFacultyLogin(LoginDto loginDto) {
		Optional<Faculty> facultyOptional = 
				facultyRepository.findByNameAndPassword(loginDto.getUserName(), loginDto.getPassword());
		if(facultyOptional.isPresent()) {
			Faculty faculty = facultyOptional.get();
			if(faculty.getName().equals(loginDto.getUserName())
					&& faculty.getPassword().equals(loginDto.getPassword())) {
				return "Login Successfull";
			}
		}
		return "Invalid User Name OR Password";
	}

	@Override
	public String addFacultyDetails(Faculty faculty) {
		try {
			facultyRepository.save(faculty);
		} catch (Exception e) {
			System.out.println("An exception occured inside FacultyServiceimpl.java");
		}
		
		return "Registration Successfull";
	}

}
