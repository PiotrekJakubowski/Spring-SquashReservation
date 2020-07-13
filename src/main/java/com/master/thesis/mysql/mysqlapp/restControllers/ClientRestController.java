package com.master.thesis.mysql.mysqlapp.restControllers;

import java.util.List;
import java.util.Optional;

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
import com.master.thesis.mysql.mysqlapp.repository.ClientRepository;
import com.master.thesis.mysql.mysqlapp.service.ClientService;

@RestController
@RequestMapping("/api")
public class ClientRestController {	
	@Autowired
	ClientRepository clientRepository;
	
	@GetMapping("/clients")
	public Iterable<Client> getClients() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/clients/{clientId}")
	public Optional<Client> getClient(@PathVariable int clientId) {
		return clientRepository.findById(clientId);		
	}

	@PostMapping("/clients")
	public Client addClient(@RequestBody Client theClient) {
		theClient.setId(0);
		clientRepository.save(theClient);
		return theClient;
	}
	
	@PutMapping("/clients")
	public Client updateClient(@RequestBody Client theClient) {
		
		clientRepository.save(theClient);
		//clientService.updateClient(theClient);
		
		return theClient;
		
	}
	
	@DeleteMapping("/clients/{clientId}")
	public String deleteClient(@PathVariable int clientId) {
		
		/*Client theClient = clientService.getClient(clientId);
		
		if (theClient == null) {
			return "Set proper client id to remove";
		}
		
		clientService.deleteClient(clientId);*/
		
		clientRepository.deleteById(clientId);
		
		return "Client with id: " + clientId + " removed";
		
	}

}
