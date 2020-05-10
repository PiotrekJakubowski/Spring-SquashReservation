package com.master.thesis.mysql.mysqlapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.master.thesis.mysql.mysqlapp.dao.ReservationDAO;
import com.master.thesis.mysql.mysqlapp.entity.Reservation;

@Service
public class ImplReservationService implements ReservationService {

	@Autowired
	ReservationDAO reservationDao;
	
	@Override
	@Transactional
	public List<Reservation> getReservations() {
		return reservationDao.getReservations();
	}

	@Override
	@Transactional
	public Reservation getReservation(int reservationId) {
		return reservationDao.getReservation(reservationId);
	}

	@Override
	@Transactional
	public Reservation saveReservation(Reservation theReservation) {
		return reservationDao.saveReservation(theReservation);
	}

	@Override
	@Transactional
	public void updateReservation(Reservation theReservation) {
		reservationDao.updateReservation(theReservation);
	}

	@Override
	@Transactional
	public void deleteReservation(int reservationId) {
		reservationDao.deleteReservation(reservationId);
	}

	@Override
	@Transactional
	public List<Reservation> getClientReservations(int clientId) {
		return reservationDao.getClientReservations(clientId);
	}
	
	@Override
	@Transactional
	public List<Reservation> getCourtReservations(int courtId) {
		return reservationDao.getCourtReservations(courtId);
	}

	@Override
	@Transactional
	public void deleteAllReservationsForClient(int clientId) {
		reservationDao.deleteAllReservationsForClient(clientId);
		
	}

	@Override
	@Transactional
	public void deleteAllReservationsForCourt(int courtId) {
		reservationDao.deleteAllReservationsForCourt(courtId);
		
	}

}
