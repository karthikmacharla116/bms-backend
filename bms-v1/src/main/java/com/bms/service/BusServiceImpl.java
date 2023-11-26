package com.bms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bms.dto.BusRouteDto;
import com.bms.dto.EnrollBusRouteDto;
import com.bms.entity.BusRoute;
import com.bms.entity.EnrollBusRoute;
import com.bms.repository.BusRepository;
import com.bms.repository.EnrollBusRepository;

/**
 * 
 * @author debugged code
 *         busRepository.updateBusRouteByBusId(busRoute.getBusNo(),
 *         busRoute.getRouteNo(), busRoute.getDriverName(),
 *         busRoute.getPhoneNum(), busRoute.getSource(),
 *         busRoute.getDestination(), busRoute.getFeesAmount(),
 *         busRoute.getStop1(), busRoute.getStop2(), busRoute.getStop3(),
 *         busRoute.getStop4(), busRoute.getBusId());
 *
 * 
 */

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepository busRepository;

	@Autowired
	private EnrollBusRepository enrollBusRepository;

	/**
	 * Problems with Mapper bean Creation
	 */
//	@Autowired
//	private BusRouteMapper busRouteMapper;

	@Override
	public String addBusRoute(BusRoute busRoute) {
		try {
			busRepository.save(busRoute);
		} catch (Exception e) {
			System.out.println("An Exception caught inside BusServiceImpl.java ");
		}

		return "A new Bus Route added Successfully";
	}

	@Override
	public List<BusRoute> getAllBusRouteDetails() {
		List<BusRoute> busRoutes = busRepository.findAll();
		try {
			if (CollectionUtils.isEmpty(busRoutes)) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("The Bus Route Data not found");
		}

		return busRoutes;
	}

	@Override
	public String enrollForBusRoute(EnrollBusRouteDto enrollBusRouteDto) {
		try {
			EnrollBusRoute enrollBusRoute = new EnrollBusRoute();
			enrollBusRoute.setName(enrollBusRouteDto.getName());
			enrollBusRoute.setBusRoute(enrollBusRouteDto.getBusRoute());
			enrollBusRoute.setRole(enrollBusRouteDto.getRole());
			enrollBusRoute.setPayment(enrollBusRouteDto.getPayment());
			enrollBusRepository.save(enrollBusRoute);
		} catch (Exception e) {
			System.out.println("An Exception caught inside BusServiceImpl.java ");
		}

		return "You are Successfully enrolled for new Bus Route!";
	}

	@Override
	public List<EnrollBusRoute> getEnrolledBusRoutesData() {
		// Need to implement Logger and Exception Handling
		return enrollBusRepository.findAll();
	}

	@Override
	public String editBusRoute(BusRouteDto busRouteDto) {

		Optional<BusRoute> busRouteOpt = busRepository.findById(busRouteDto.getBusId());
		if (busRouteOpt.isPresent()) {
			BusRoute busRoute = busRouteOpt.get();
			busRoute.setBusId(busRouteDto.getBusId());
			busRoute.setBusNo(busRouteDto.getBusNo());
			busRoute.setRouteNo(busRouteDto.getRouteNo());
			busRoute.setDriverName(busRouteDto.getDriverName());
			busRoute.setPhoneNum(busRouteDto.getPhoneNum());
			busRoute.setSource(busRouteDto.getSource());
			busRoute.setDestination(busRouteDto.getDestination());
			busRoute.setFeesAmount(busRouteDto.getFeesAmount());
			busRoute.setStop1(busRouteDto.getStop1());
			busRoute.setStop2(busRouteDto.getStop2());
			busRoute.setStop3(busRouteDto.getStop3());
			busRoute.setStop4(busRouteDto.getStop4());

			busRepository.saveAndFlush(busRoute);

			return "Bus Route Edited Successfully";
		} else {
			return "Bus Route Not Edited Successfully";
		}

	}

	@Override
	public String deleteBusRoute(int busId) {
		Optional<BusRoute> busRouteOpt = busRepository.findById(busId);
		if(busRouteOpt.isPresent()) {
			busRepository.delete(busRouteOpt.get());
			return "Record deleted successfully!";
		}else {
			return "Something went wrong";
		}
		
	}

}
