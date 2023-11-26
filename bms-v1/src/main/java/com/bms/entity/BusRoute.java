package com.bms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Sample JSON data { "busNo": "TS07A1231", "routeNo": "12",
 *         "driverName": "Appa rao", "phoneNum": "23934632", "source" :
 *         "secunderabad", "destination": "Gandipet", "feesAmount": "12000",
 *         "stop1": "Tank bund", "stop2": "Lakdikapul", "stop3": "Mehdipatnam",
 *         "stop4": "LungarHouz" }
 *
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusRoute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busId;
	private String busNo;
	private String routeNo;
	private String driverName;
	private String phoneNum;
	private String source;
	private String destination;
	private String feesAmount;
	private String stop1;
	private String stop2;
	private String stop3;
	private String stop4;

}
