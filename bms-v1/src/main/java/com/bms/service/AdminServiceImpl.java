package com.bms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dto.LoginDto;
import com.bms.entity.Admin;
import com.bms.entity.EnrollBusRoute;
import com.bms.repository.AdminRepository;
import com.bms.repository.EnrollBusRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private EnrollBusRepository enrollBusRepository;

	@Override
	public String addAdminDetails(Admin admin) {
		adminRepository.save(admin);
		return "Registration Successfull";
	}

	@Override
	public String validateAdminLogin(LoginDto loginDto) {
		Optional<Admin> adminOptional = adminRepository.findByNameAndPassword(loginDto.getUserName(),
				loginDto.getPassword());
		if (adminOptional.isPresent()) {
			Admin admin = adminOptional.get();
			if (admin.getName().equals(loginDto.getUserName()) && admin.getPassword().equals(loginDto.getPassword())) {
				return "Login Successfull";
			}
		}
		return "Invalid User Name OR Password";
	}

	@Override
	public List<EnrollBusRoute> getAllEnrolledBusDetails() {
		// Need to implement loggers and exception handling
		return enrollBusRepository.findAll();
	}

}
