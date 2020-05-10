package com.master.thesis.mysql.mysqlapp.service;

import java.util.List;

import com.master.thesis.mysql.mysqlapp.entity.Client;


public interface ClientService {
	
	public List<Client> getClients();
	
	public Client getClient(int clientId);
	
	public void saveClient(Client theClient);
	
	public void updateClient(Client theClient);
	
	public void deleteClient(int clientId);
}
