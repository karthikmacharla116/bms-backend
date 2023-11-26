package com.bms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dto.BusRouteDto;
import com.bms.dto.EnrollBusRouteDto;
import com.bms.entity.BusRoute;
import com.bms.entity.EnrollBusRoute;
import com.bms.service.BusService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BusController {

	Logger logger = LoggerFactory.getLogger(BusController.class);

	@Autowired
	private BusService busService;

	@PostMapping("/addBusRoute")
	public ResponseEntity<String> addNewBusRoute(@RequestBody BusRoute busRoute) throws JsonProcessingException {
		logger.info(" /admin/addBusRoute API called with bus data {}", busRoute);
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(busService.addBusRoute(busRoute));
		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

	@PutMapping("/editBusRoute")
	public ResponseEntity<String> editBusRoute(@RequestBody BusRouteDto busRouteDto) throws JsonProcessingException {
		logger.info(" /admin/editBusRoute API called with bus data {}", busRouteDto);
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(busService.editBusRoute(busRouteDto));
		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

	@DeleteMapping("/deleteBusRoute/{busId}")
	public ResponseEntity<String> deleteBusRoute(@PathVariable("busId") String busId) throws JsonProcessingException {
		logger.info(" /admin/deleteBusRoute API called with bus data of {}", busId);
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(busService.deleteBusRoute(Integer.valueOf(busId)));
		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

	@GetMapping("/busRoutes")
	public List<BusRoute> getAllBusRoutes() {
		return busService.getAllBusRouteDetails();
	}

	@PostMapping("/enrollBusRoute")
	public ResponseEntity<String> enrollNewBusRoute(@RequestBody EnrollBusRouteDto enrollBusRouteDto)
			throws JsonProcessingException {
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(busService.enrollForBusRoute(enrollBusRouteDto));
		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
	}

	@GetMapping("/enrollBusRoute")
	public List<EnrollBusRoute> getEnrolledBusRouteDetails() {
		return busService.getEnrolledBusRoutesData();
	}

}
