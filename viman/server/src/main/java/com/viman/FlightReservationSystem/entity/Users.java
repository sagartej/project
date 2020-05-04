package com.viman.FlightReservationSystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name="users")
public class Users implements Serializable{
	
	@Id
	@Column(name="USERID")
	private Integer userId;
	
	@Column(name="FNAME")
	private String fname;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="PHONE")
	private long phone;
	
	
	public  Users() {
		
	}


	
	public Users(Integer userId, String fname, String lname, @Min(10) int age, String email, String password, long phone) {
		
		this.userId = userId;
		this.fname = fname;
		
		this.email = email;
		this.password = password;
		this.phone = phone;
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}





	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


}