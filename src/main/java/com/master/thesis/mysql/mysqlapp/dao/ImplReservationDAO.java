package com.master.thesis.mysql.mysqlapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.master.thesis.mysql.mysqlapp.entity.Reservation;

@Repository
public class ImplReservationDAO implements ReservationDAO {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Reservation> getReservations() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from Reservation order by id", Reservation.class).getResultList();
	}

	@Override
	public Reservation getReservation(int reservationId) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Reservation.class, reservationId);
	}

	@Override
	public Reservation saveReservation(Reservation theReservation) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theReservation);
		return theReservation;
	}

	@Override
	public void updateReservation(Reservation theReservation) {
		Session session = entityManager.unwrap(Session.class);
		session.update(theReservation);
	}

	@Override
	public void deleteReservation(int reservationId) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("delete from Reservation where id=:reservationId");
		theQuery.setParameter("reservationId", reservationId);
		theQuery.executeUpdate();
	}

	@Override
	public List<Reservation> getClientReservations(int clientId) {
		Session session = entityManager.unwrap(Session.class);
		String query = "from Reservation where client_id=" + clientId;
		return session.createQuery(query, Reservation.class).getResultList();
	}

	@Override
	public List<Reservation> getCourtReservations(int courtId) {
		Session session = entityManager.unwrap(Session.class);
		String query = "from Reservation where court_id=" + courtId;
		return session.createQuery(query, Reservation.class).getResultList();

	}

	@Override
	public void deleteAllReservationsForClient(int clientId) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("delete from Reservation where client_id=:clientId");
		theQuery.setParameter("clientId", clientId);
		theQuery.executeUpdate();
	}

	@Override
	public void deleteAllReservationsForCourt(int courtId) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("delete from Reservation where court_id=:courtId");
		theQuery.setParameter("courtId", courtId);
		theQuery.executeUpdate();
	}

	@Override
	public void deleteAllReservations() {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("delete from Reservation");
		theQuery.executeUpdate();
	}
	
	@Override
	public void deleteRandomReservation() {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createSQLQuery("DELETE FROM Reservation ORDER BY RAND() LIMIT 1");
		theQuery.executeUpdate();
	}

}
