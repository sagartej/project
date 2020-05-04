package com.viman.FlightReservationSystem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.viman.FlightReservationSystem.entity.*;
import com.viman.FlightReservationSystem.utility.globalResources;
@Repository
public class daoImpl implements daoInterface {
	private Logger logger = globalResources.getLogger(daoImpl.class);
	
	@Autowired
	private EntityManager entityManager;
	
	
	public daoImpl() {
	}

    @Override
	public void addFlight( Flights f)
	{

		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(f);
	}
	
    @Override
	public void updateFlight(Flights f) {

		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(f);
		
		
	}

    @Override
	public Bookings getBookingDetails(Integer bookingId)
	{
    	String methodName="getBookingDetails()";
		logger.info(methodName+" called");
		return entityManager.find(Bookings.class, bookingId);
	}
	
    @Override
	public boolean signup(Users u) {
    	
    	String methodName="signup()";
		logger.info(methodName+" called");
		
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(u);
	
		return true;
	}

	/*@Override
	public boolean registerUser(Users users) {
		// TODO Auto-generated method stub
		return false;
		}*/
	

	@Transactional
	@Override
	public boolean addBooking(Bookings b)
	{
		String methodName="addBooking()";
		logger.info(methodName+" called");
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(b);
		return true;
	}

	@Override
	public Integer login(String email, String password) {
		String methodName="login()";
		logger.info(methodName+" called");
		try {
			String command = "select u.userId from Users u where u.email = :uName and u.password = :pass";
			TypedQuery<Integer> query = entityManager.createQuery(command,Integer.class);
			query.setParameter("uName", email);
			query.setParameter("pass", password);
			Integer uid = 0;
			uid = query.getSingleResult();
		
			if(uid > 0)
				return uid;
			else
				return 0;
			}
			catch (NoResultException e) {
				return 0;
			}	
	}


	
	@Transactional
	@Override
	public  List<Flights> searchFlight(String from1, String to1,String day)  {
		String methodName="searchFlight()";
		logger.info(methodName+" called");
		try {
			String qStr = "SELECT f FROM Flights f WHERE f.source=:psource and f.desti=:pdest and f.fdate=:pday";
			TypedQuery<Flights> query = entityManager.createQuery(qStr, Flights.class);
			query.setParameter("psource", from1);
			query.setParameter("pdest", to1);
			query.setParameter("pday", day);
			List<Flights> flights = query.getResultList();
	
			return flights;
			}
			catch (NoResultException e) {
				
				return null;
			}
	}
	
	@Override
	public Flights getFlightById(int flightId) {
		String methodName="grtFlightById()";
		logger.info(methodName+" called");
		
		String qStr = "SELECT f FROM Flights f WHERE f.flightId=:fId";
		TypedQuery<Flights> query = entityManager.createQuery(qStr, Flights.class);
		query.setParameter("fId", flightId);
		Flights flight = query.getSingleResult();

		return flight;

	}


	@Override
	public boolean cancelBooking(Bookings b) {
		String methodName="cancelBooking()";
		logger.info(methodName+" called");

		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(b);
		cs.delete(b);
	
		return true;
	}


	@Override
	public List<Bookings> viewBookings(int userid) {
		String methodName="viewBookings()";
		logger.info(methodName+" called");
		String qStr = "SELECT b FROM Bookings b WHERE userId=:uId";
		TypedQuery<Bookings> query = entityManager.createQuery(qStr, Bookings.class);
		query.setParameter("uId", userid);
		List<Bookings> bookings = query.getResultList();
		return bookings;
	}
	
}
