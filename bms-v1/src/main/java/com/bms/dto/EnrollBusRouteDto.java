package com.bms.dto;

import com.bms.entity.BusRoute;
import com.bms.entity.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollBusRouteDto {

	private BusRoute busRoute;
	private String name;
	//private String amount;
	private String role;
	private Payment payment;
}
