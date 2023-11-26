package com.bms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author LOGGER QUERY: Hibernate: create table student (studentid integer not
 *         null auto_increment, address varchar(255), department varchar(255),
 *         dob varchar(255), name varchar(255), password varchar(255), phone_num
 *         varchar(255), route varchar(255), primary key (studentid))
 *
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentid;
	private String name;
	private String password;
	private String dob;
	private String department;
	private String phoneNum;
	private String address;
	private String route;

}
