package com.bms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dto.LoginDto;
import com.bms.entity.Student;
import com.bms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student getStudentDetailsById(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public String validateStudentLogin(LoginDto loginDto) {
		Optional<Student> studentOptional = studentRepository.findByNameAndPassword(loginDto.getUserName(),
				loginDto.getPassword());

		if (studentOptional.isPresent()) {
			Student student = studentOptional.get();
			if (student.getName().equals(loginDto.getUserName())
					&& student.getPassword().equals(loginDto.getPassword())) {
				return "Login Successfull";
			}

		}

		return "Invalid User name OR Password";
	}

	@Override
	public String addStudentDetails(Student student) {
		try {
			studentRepository.save(student);
		} catch (Exception e) {
			System.out.println("An exception occured inside StudentServiceImpl.java");
		}
		
		return "Registration Successfull";
	}

}
