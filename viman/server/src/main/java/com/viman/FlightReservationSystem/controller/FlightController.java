package com.viman.FlightReservationSystem.controller;


import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.viman.FlightReservationSystem.entity.*;
import com.viman.FlightReservationSystem.service.serviceImpl;
import com.viman.FlightReservationSystem.utility.globalResources;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FlightController {
	private Logger logger = globalResources.getLogger(FlightController.class);

	@Autowired
	serviceImpl service;	

	@PostMapping("/addUser")
	public boolean signup(@RequestBody Users users)
	{
		String methodName="signup()";
		logger.info(methodName+" called");
		return service.signup(users);
	}

	@GetMapping("/login/{email}/{pass}")
	public Integer login(@PathVariable String email,@PathVariable String pass) {
		String methodName="login()";
		logger.info(methodName+" called");
		return service.login(email, pass);
	}
	
	@GetMapping("/searchFlight/{from}/{to}/{fdate}")
	public List<Flights> searchFlight(@PathVariable String from,@PathVariable String to,@PathVariable String fdate)
	{
		String methodName="searchFlight()";
		logger.info(methodName+" called");
		return service.searchFlight(from, to,fdate);
	}
	@GetMapping("/book/{fid}/{uid}/{fname}/{lname}/{dob}")
	public Integer bookFlight(@PathVariable Integer fid,@PathVariable Integer uid,@PathVariable String fname,@PathVariable String lname,@PathVariable String dob)
	{
		String methodName="bookFlight()";
		logger.info(methodName+" called");
		return service.book(fid, uid,fname,lname,dob);
	}
	
	@GetMapping("/view/{uid}")
	public List<Bookings> viewBookings(@PathVariable Integer uid)
	{
		String methodName="viewBookings()";
		logger.info(methodName+" called");
		return service.viewBookings(uid);
	}
	
	
	@GetMapping("/cancel/{bid}")
	public boolean cancelFlight(@PathVariable Integer bid)
	{
		String methodName="cancelFlight()";
		logger.info(methodName+" called");
		return service.cancel(bid);
	}	
}
