package com.master.thesis.mysql.mysqlapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.master.thesis.mysql.mysqlapp.entity.Client;
import com.master.thesis.mysql.mysqlapp.repository.ClientRepository;
import com.master.thesis.mysql.mysqlapp.service.ClientService;
import com.master.thesis.mysql.mysqlapp.service.ReservationService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/web")
public class ClientWebPageController {

	private ClientRepository clientRepository;
	private ReservationService reservationService;

	@Autowired
	public ClientWebPageController(ClientRepository clientRepository, ReservationService reservationService) {
		this.clientRepository = clientRepository;
		this.reservationService = reservationService;
	}

	@GetMapping("/clients")
	public String clientList(HttpServletRequest request, Model model) {
		int page = 0; //default page number is 0 (yes it is weird)
		int size = 10; //default page size is 10

		if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
			page = Integer.parseInt(request.getParameter("page")) - 1;
		}

		if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
			size = Integer.parseInt(request.getParameter("size"));
		}

		//List<Client> clientList = new ArrayList<>();
		//clientList = (List<Client>) clientRepository.findAll(PageRequest.of(page, size));
		System.out.println("Add attribute to model");
		model.addAttribute("clients", clientRepository.findAll(PageRequest.of(page, size)));
		return "clients-table";
	}
	
	@GetMapping("/delete/{clientId}")
	public String deleteClient(@PathVariable int clientId) {
		clientRepository.deleteById(clientId);
		return "redirect:/web/clients";
		//test
	}

	@GetMapping("/deleteAll")
	public String deleteAllClients() {
		clientRepository.deleteAll();
		return "redirect:/web/clients";
	}
	
	@GetMapping("/deleteRandomReservation")
	public String deleteClient() {
		reservationService.deleteRandomReservation();
		return "redirect:/web/clients";
	}

	@GetMapping("/update/{clientId}")
	public String updateClientForm(@PathVariable int clientId, Model model) {
		Optional<Client> client = clientRepository.findById(clientId);
		model.addAttribute("client", client);
		return "client-form";

	}

	@PostMapping("/clientSave")
	public String saveClient(@ModelAttribute("client") Client theClient) {		
		clientRepository.save(theClient);
		return "redirect:/web/clients";
	}

	@GetMapping("/addClient")
	public String addClient(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);
		return "client-form";

	}

	@GetMapping("/clientReservations/{clientId}")
	public String openClientReservations(@PathVariable int clientId) {
		System.out.println("ClientId: " + clientId);
		return "redirect:/reservation/clientReservations/" + clientId;
	}

}
