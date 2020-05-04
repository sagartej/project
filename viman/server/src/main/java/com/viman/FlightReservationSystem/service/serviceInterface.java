package com.viman.FlightReservationSystem.service;

import java.util.List;

import com.viman.FlightReservationSystem.entity.*;;

public interface serviceInterface {

	public boolean signup(Users us);
	
	public Integer login(String email, String password);
	
	public List<Flights> searchFlight(String from,String to,String day);
	
	public Integer book(int fid,Integer uid,String fname,String lname,String dob);
	
	public boolean cancel(Integer bid);
	
	public List<Bookings> viewBookings(int uid);

}
