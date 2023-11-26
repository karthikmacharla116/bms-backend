package com.bms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dto.LoginDto;
import com.bms.entity.Admin;
import com.bms.entity.EnrollBusRoute;
import com.bms.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;

	@PostMapping("/admin/register")
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin) throws JsonProcessingException {
		logger.info("/admin/register API is called with details {}", admin);
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(adminService.addAdminDetails(admin));
		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

	@PostMapping("/admin/login")
	public ResponseEntity<String> adminLogin(@RequestBody LoginDto loginDto) throws JsonProcessingException {
		logger.info(" /admin/login api called with credentials {}", loginDto);
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(adminService.validateAdminLogin(loginDto));
		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

	@GetMapping("/enrolledUsersData")
	public List<EnrollBusRoute> getAllEnrolledBusData() {
		return adminService.getAllEnrolledBusDetails();
	}

}
