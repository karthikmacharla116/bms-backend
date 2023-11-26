package com.bms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusRouteDto {

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
