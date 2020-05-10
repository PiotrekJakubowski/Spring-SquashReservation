package com.master.thesis.mysql.mysqlapp.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.thesis.mysql.mysqlapp.entity.Client;
import com.master.thesis.mysql.mysqlapp.service.ClientService;

@RestController
@RequestMapping("/api")
public class ClientRestController {

	@Autowired
	ClientService clientService;

	@GetMapping("/clients")
	public List<Client> getClients() {

		return clientService.getClients();
	}
	
	@GetMapping("/clients/{clientId}")
	public Client getClient(@PathVariable int clientId) {
		
		return clientService.getClient(clientId);
		
	}

	@PostMapping("/clients")
	public Client addClient(@RequestBody Client theClient) {

		// set id to 0 force to save a new item and not to update it
		theClient.setId(0);

		clientService.saveClient(theClient);

		return theClient;
	}
	
	@PutMapping("/clients")
	public Client updateClient(@RequestBody Client theClient) {
		
		clientService.updateClient(theClient);
		
		return theClient;
		
	}
	
	@DeleteMapping("/clients/{clientId}")
	public String deleteClient(@PathVariable int clientId) {
		
		Client theClient = clientService.getClient(clientId);
		
		if (theClient == null) {
			return "Set proper client id to remove";
		}
		
		clientService.deleteClient(clientId);
		
		return "Client with id: " + clientId + " removed";
		
	}

}
