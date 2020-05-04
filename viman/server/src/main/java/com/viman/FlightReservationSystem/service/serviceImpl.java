package com.viman.FlightReservationSystem.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viman.FlightReservationSystem.dao.*;
import com.viman.FlightReservationSystem.entity.*;
import com.viman.FlightReservationSystem.utility.globalResources;

@Service
@Transactional
public class serviceImpl implements serviceInterface {
	private Logger logger = globalResources.getLogger(serviceImpl.class);

	@Autowired
	private daoImpl dao;
	@Autowired
	private EntityManager entityManager;

	private static int bookingId;

	public serviceImpl() {
	}
	
	@Transactional
	@Override
	public boolean signup(Users us) {
		String methodName="signup()";
		logger.info(methodName+" called");
		
	/*	String command = "select count(u.userId) from Users  where u.email = :em or u.password = :ph";
		TypedQuery<Long> query = entityManager.createQuery(command, Long.class);
		query.setParameter("em", us.getEmail());
		query.setParameter("ph", us.getPhone());
		
		long count = query.getSingleResult();
		
		if(count>0)
		{
			return false;
		}*/
		
		
		Integer userId = 1;
		String command = "select count(u.userId) from Users u";
		 TypedQuery<Long> query = entityManager.createQuery(command, Long.class);
		long count = query.getSingleResult();
		
		
		if (count > 0) {
			command = "select max(ud.userId) from Users ud";
			TypedQuery<Integer> query2 = entityManager.createQuery(command, Integer.class);
			Integer uid = query2.getSingleResult();
			userId = uid + 1;
		}
		us.setUserId(userId);
		return dao.signup(us);
	}

	@Override
	public Integer login(String email, String password) {
		String methodName="login()";
		logger.info(methodName+" called");
		// TODO Auto-generated method stub
		return dao.login(email, password);
	}

	@Override
	public List<Flights> searchFlight(String from, String to, String day) {
		String methodName="searchFlight()";
		logger.info(methodName+" called");
		// TODO Auto-generated method stub
		return dao.searchFlight(from, to,day);
	}

	@Override
	public Integer book(int fid, Integer uid, String fname,String lname,String dob) {
		String methodName="book()";
		logger.info(methodName+" called");
		Integer temp = bookingId;
		Bookings b = new Bookings();
		Flights f = dao.getFlightById(fid);

		if (f.getSeats() > 0) {
			f.setSeats(f.getSeats() - 1);
			dao.updateFlight(f);

			String command = "select count(b.bookingId) from Bookings b";
			TypedQuery<Long> query1 = entityManager.createQuery(command, Long.class);
			long count = query1.getSingleResult();
			if (count > 0) {
				command = "select max(b.bookingId) from Bookings b";
				TypedQuery<Integer> query2 = entityManager.createQuery(command, Integer.class);
				Integer id = query2.getSingleResult();
				temp = id + 1;
			} else {
				temp = 1001;
			}

			command = "select user from Users user where user.userId =: puserid";
			TypedQuery<Users> query2 = entityManager.createQuery(command, Users.class);
			query2.setParameter("puserid", uid);

			Users user = query2.getSingleResult();
			b.setPname(fname);
			b.setPlname(lname);
			b.setDob(dob);
			b.setBookingId(temp);
			b.setUser(user);
			b.setFlight(f);

			if (dao.addBooking(b)) {
				return temp;
			}

		} else {
			System.out.println("No tickets");
		}
		return 0;
	}

	@Override
	public boolean cancel(Integer bid) {

		String methodName="cancel()";
		logger.info(methodName+" called");
		String qStr = "SELECT b FROM Bookings b WHERE b.bookingId =: bId";
		TypedQuery<Bookings> query = entityManager.createQuery(qStr, Bookings.class);
		query.setParameter("bId", bid);
		Bookings b = query.getSingleResult();

		if (b != null) {
			int availableSeats = b.getFlight().getSeats() + 1;
			b.getFlight().setSeats(availableSeats);

			dao.cancelBooking(b);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Bookings> viewBookings(int uid) {
		String methodName="viewBookings()";
		logger.info(methodName+" called");
		return dao.viewBookings(uid);
	}
}
