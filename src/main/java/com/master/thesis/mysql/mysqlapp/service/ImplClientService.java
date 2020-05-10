package com.master.thesis.mysql.mysqlapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.master.thesis.mysql.mysqlapp.dao.ClientDAO;
import com.master.thesis.mysql.mysqlapp.entity.Client;

@Service
public class ImplClientService implements ClientService {

	@Autowired
	ClientDAO clientDao;

	@Override
	@Transactional
	public List<Client> getClients() {
		return clientDao.getClients();
	}

	@Override
	@Transactional
	public void saveClient(Client theClient) {
		clientDao.saveClient(theClient);
	}

	@Override
	@Transactional
	public void updateClient(Client theClient) {
		clientDao.updateClient(theClient);
	}

	@Override
	@Transactional
	public Client getClient(int clientId) {

		return clientDao.getClient(clientId);
	}

	@Override
	@Transactional
	public void deleteClient(int clientId) {
		
		clientDao.deleteClient(clientId);
		
	}

	
	
}

