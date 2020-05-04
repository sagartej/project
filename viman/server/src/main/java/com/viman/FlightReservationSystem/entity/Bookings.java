package com.viman.FlightReservationSystem.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Bookings implements Serializable{

	@Id
	@Column(name = "BOOKINGID")
	private Integer bookingId;
	
	@Column(name = "PNAME")
	private String pname;
	
	@Column(name = "PLNAME")
	private String plname;
	
	@Column(name = "DOB")
	private String dob;
	
	@ManyToOne
	@JoinColumn(name = "FLIGHTID")
	private Flights flight;
	
	@ManyToOne
	@JoinColumn(name = "USERID")
	private Users user;



	public Bookings() {
	}
	













	public Bookings(Integer bookingId, String pname, String plname, String dob, Flights flight, Users user) {
		super();
		this.bookingId = bookingId;
		this.pname = pname;
		this.plname = plname;
		this.dob = dob;
		this.flight = flight;
		this.user = user;
	}














	public String getPname() {
		return pname;
	}














	public void setPname(String pname) {
		this.pname = pname;
	}














	public String getPlname() {
		return plname;
	}














	public void setPlname(String plname) {
		this.plname = plname;
	}














	public String getDob() {
		return dob;
	}














	public void setDob(String dob) {
		this.dob = dob;
	}














	public Flights getFlight() {
		return flight;
	}




	public void setFlight(Flights flight) {
		this.flight = flight;
	}




	public Users getUser() {
		return user;
	}




	public void setUser(Users user) {
		this.user = user;
	}




	public Integer getBookingId() {
		return bookingId;
	}




	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}




	



	
	


}
