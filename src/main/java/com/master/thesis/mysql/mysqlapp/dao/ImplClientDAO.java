package com.master.thesis.mysql.mysqlapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.master.thesis.mysql.mysqlapp.entity.Client;

@Repository
public class ImplClientDAO implements ClientDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Client> getClients() {
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);

		return session
				.createQuery("from Client order by id", Client.class)
				.getResultList();

	}

	@Override
	public void saveClient(Client theClient) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(theClient);
		
	}
	
	@Override
	public void updateClient(Client theClient) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.update(theClient);
		
	}

	@Override
	public Client getClient(int clientId) {
		
		Session session = entityManager.unwrap(Session.class);

		Client theClient = session.get(Client.class, clientId);
		
		return theClient;
	}

	@Override
	public void deleteClient(int clientId) {
		
		Session session = entityManager.unwrap(Session.class);

		Query theQuery =
				session.createQuery("delete from Client where id=:clientId");
		theQuery.setParameter("clientId", clientId);
		
		theQuery.executeUpdate();
		
	}

}
