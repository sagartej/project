package com.viman.FlightReservationSystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.viman.FlightReservationSystem.dao.daoImpl;
import com.viman.FlightReservationSystem.dao.daoInterface;
import com.viman.FlightReservationSystem.entity.Flights;
import com.viman.FlightReservationSystem.entity.Users;
import com.viman.FlightReservationSystem.entity.Bookings;
import com.viman.FlightReservationSystem.service.serviceImpl;
import com.viman.FlightReservationSystem.service.serviceInterface;
import com.viman.FlightReservationSystem.utility.globalResources;

@SpringBootTest
class FlightReservationSystemApplicationTests {
	

	@Test
	void contextLoads() {
	}

private static Logger logger = globalResources.getLogger(FlightReservationSystemApplicationTests.class);
	
	@Autowired
	serviceImpl service;
	
	

	
	@BeforeAll
	static void setUpBeforeClass() {
		logger.info("test SetUpClass called");
	}
	
	@BeforeEach
	void setup() {
		logger.info("Test Case Started");
		System.out.println("Test Case Started");
	}
	
	@AfterEach
	void tearDown() {
		logger.info("Test Case ended");
		System.out.println("Test Case ended");
	}
	
	
	
	@Test
	@DisplayName("Flight Booked")
	@Rollback(true)
	public void bookFlight() {
	
		int be;
		int te;
		
		te= service.book(1001,1,"sagar","tejwani","1998-06-05");
		be= service.book(1002,1,"smith","tejwani","1998-06-05");
		
		assertEquals(te+1, be);
		
	
	}
	
	@Test
	@DisplayName("Registeration successful")
	@Rollback(true)
	public void createUser() {
		Users user = new Users();
		user.setUserId(90);
		user.setFname("Lucky");
		user.setEmail("lucky@gmail.com");
		user.setPassword("password");
		user.setPhone(934444444);
		
		boolean status = service.signup(user);
		
		assertEquals(true, status);
	}
	

	

	@Test
	@DisplayName("LoggedIn successfully")
	@Rollback(true)
	public void loginTest() {
		String methodName = "login()";
		logger.info(methodName + " called");
		
		Integer value = service.login("sagar@gmail.com","viman");
		assertNotEquals(0, value);
	}
	
	@Test
	@DisplayName("LoggedIn successfully 2")
	@Rollback(true)
	public void loginTest2() {
		String methodName = "login()";
		logger.info(methodName + " called");
		
		Integer value = service.login("smith@gmail.com","viman");
		assertEquals(2, value);
	}
	
	@Test
	@DisplayName("Search Flight")
	@Rollback(true)
	public void searchFlight() {
		
		List <Flights> flights = service.searchFlight("pune", "indore","2020-05-07");
				
		assertNotNull(flights);
	
	}
	
	@Test
	@DisplayName("Search Flight")
	@Rollback(true)
	public void viewTickets() {
		
		List <Bookings> tickets = service.viewBookings(1);
		
		assertNotNull(tickets);
	
	}
	
}
