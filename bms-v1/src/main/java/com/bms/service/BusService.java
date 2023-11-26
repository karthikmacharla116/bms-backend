package com.bms.service;

import java.util.List;

import com.bms.dto.BusRouteDto;
import com.bms.dto.EnrollBusRouteDto;
import com.bms.entity.BusRoute;
import com.bms.entity.EnrollBusRoute;

public interface BusService {

	String addBusRoute(BusRoute busRoute);

	List<BusRoute> getAllBusRouteDetails();

	String enrollForBusRoute(EnrollBusRouteDto enrollBusRouteDto);

	List<EnrollBusRoute> getEnrolledBusRoutesData();

	String editBusRoute(BusRouteDto busRouteDto);

	String deleteBusRoute(int busId);

}
