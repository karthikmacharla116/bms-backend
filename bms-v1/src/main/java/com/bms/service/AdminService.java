package com.bms.service;

import java.util.List;

import com.bms.dto.LoginDto;
import com.bms.entity.Admin;
import com.bms.entity.EnrollBusRoute;

public interface AdminService {

	String addAdminDetails(Admin admin);

	String validateAdminLogin(LoginDto loginDto);

	List<EnrollBusRoute> getAllEnrolledBusDetails();

}
