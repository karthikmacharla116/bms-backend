package com.bms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author 
 * In Progress
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	
	private String name;
	private String password;
	private String dob;
	private String department;
	private String phoneNum;
	private String address;
	private String route;

}
