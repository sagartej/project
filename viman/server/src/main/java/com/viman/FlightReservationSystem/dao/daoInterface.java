package com.viman.FlightReservationSystem.dao;

import java.util.List;

import com.viman.FlightReservationSystem.entity.*;


public interface daoInterface {
	
	public void addFlight(Flights f);
	
	public void updateFlight(Flights f);
	
	public Bookings getBookingDetails(Integer bookingId);
	
	public boolean signup(Users u);
	
	public boolean addBooking(Bookings b);
	
	public Integer login(String email, String password);
	
	public List<Flights> searchFlight(String from1,String to1,String day);
	
	public Flights getFlightById(int flightId);

	public boolean cancelBooking(Bookings b);
	
	public List<Bookings> viewBookings(int userid);
}
