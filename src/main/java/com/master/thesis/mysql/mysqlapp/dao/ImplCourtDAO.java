package com.master.thesis.mysql.mysqlapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.master.thesis.mysql.mysqlapp.entity.Court;

@Repository
public class ImplCourtDAO implements CourtDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Court> getCourts() {
		
		Session session = entityManager.unwrap(Session.class);

		return session
				.createQuery("from Court order by id", Court.class)
				.getResultList();
	}

	@Override
	public Court getCourt(int courtId) {
		
		Session session = entityManager.unwrap(Session.class);

		Court theCourt = session.get(Court.class, courtId);
		
		return theCourt;
	}

	@Override
	public void saveCourt(Court theCourt) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(theCourt);

	}

	@Override
	public void updateCourt(Court theCourt) {

		Session session = entityManager.unwrap(Session.class);
		
		session.update(theCourt);
		
	}

	@Override
	public void deleteCourt(int courtId) {

		Session session = entityManager.unwrap(Session.class);

		Query theQuery =
				session.createQuery("delete from Court where id=:courtId");
		theQuery.setParameter("courtId", courtId);
		
		theQuery.executeUpdate();
		
	}

}
