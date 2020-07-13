package com.master.thesis.mysql.mysqlapp.dao;

import java.util.List;

import com.master.thesis.mysql.mysqlapp.entity.Reservation;

public interface ReservationDAO {

	public List<Reservation> getReservations();
	public List<Reservation> getClientReservations(int clientId);
	public List<Reservation> getCourtReservations(int courtId);
	public Reservation getReservation(int reservationId);	
	public Reservation saveReservation(Reservation theReservation);
	public void updateReservation(Reservation theReservation);
	public void deleteReservation(int reservationId);
	public void deleteAllReservationsForClient(int clientId);
	public void deleteAllReservationsForCourt(int courtId);
	public void deleteAllReservations();
	public void deleteRandomReservation();
}


