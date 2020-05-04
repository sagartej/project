package com.viman.FlightReservationSystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "flights")
public class Flights implements Serializable{

	@Id
	@Column(name="FLIGHTID")
	private int flightId;
	
	@Column(name="AIRLINE")
	private String airline;
	
	@Column(name = "SOURCE")
	private String source;
	
	@Column(name = "DESTI")
	private String desti;
	
	@Column(name = "FDATE")
	private String fdate;
	
	@Column(name = "DEPT")
	private String dept;
	
	@Column(name = "ARR")
	private String arr;
	
	@Column(name = "FARE")
	private int fare;
	
	
	@Column(name="PHOTO")
	private String photo;
	
	@Column(name = "SEATS")
	private int seats;
	
	@Column(name = "BAGGAGE")
	private int baggage;
	
	@Column(name = "MEAL")
	private String meal;
	
	
	
	public Flights() {
		
	}


	




















	public Flights(int flightId,String airline, String source, String desti, String fdate, String dept, String arr, int fare,
			Double taxPrice, String photo, int seats, int baggage, String meal) {
		super();
		this.flightId = flightId;
		this.airline=airline;
		this.source = source;
		this.desti = desti;
		this.fdate = fdate;
		this.dept = dept;
		this.arr = arr;
		this.fare = fare;
	
		this.photo = photo;
		this.seats = seats;
		this.baggage = baggage;
		this.meal = meal;
	}























	public String getAirline() {
		return airline;
	}























	public void setAirline(String airline) {
		this.airline = airline;
	}























	public int getFlightId() {
		return flightId;
	}























	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}























	public String getFdate() {
		return fdate;
	}























	public void setFdate(String fdate) {
		this.fdate = fdate;
	}























	public int getBaggage() {
		return baggage;
	}























	public void setBaggage(int baggage) {
		this.baggage = baggage;
	}























	public String getMeal() {
		return meal;
	}























	public void setMeal(String meal) {
		this.meal = meal;
	}























	public String getPhoto() {
		return photo;
	}
















	public void setPhoto(String photo) {
		this.photo = photo;
	}













	




































	public String getSource() {
		return source;
	}








	public void setSource(String source) {
		this.source = source;
	}








	public String getDesti() {
		return desti;
	}








	public void setDesti(String desti) {
		this.desti = desti;
	}








	public String getDept() {
		return dept;
	}








	public void setDept(String dept) {
		this.dept = dept;
	}








	public String getArr() {
		return arr;
	}








	public void setArr(String arr) {
		this.arr = arr;
	}








	public int getFare() {
		return fare;
	}








	public void setFare(int fare) {
		this.fare = fare;
	}








	public int getSeats() {
		return seats;
	}








	public void setSeats(int seats) {
		this.seats = seats;
	}





	
}
