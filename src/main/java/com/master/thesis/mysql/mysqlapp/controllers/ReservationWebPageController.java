package com.master.thesis.mysql.mysqlapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.master.thesis.mysql.mysqlapp.entity.Client;
import com.master.thesis.mysql.mysqlapp.entity.Reservation;
import com.master.thesis.mysql.mysqlapp.service.ClientService;
import com.master.thesis.mysql.mysqlapp.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationWebPageController {

	@Autowired
	ReservationService reservationService;
	
	@Autowired
	ClientService clientService;
	
	@GetMapping("/clientReservations/{clientId}")
	public String reservationList(@PathVariable int clientId, Model model) {
		
		List<Reservation> clientReservations = new ArrayList<Reservation>();
		clientReservations = reservationService.getClientReservations(clientId);

		model.addAttribute("reservations", clientReservations);
		model.addAttribute("clientId", clientId);

		return "reservations-table";
	}
	
	@GetMapping("/updateReservation/{reservationId}")
	public String updateReservationForm(@PathVariable int reservationId, Model model) {
		Reservation reservation = reservationService.getReservation(reservationId);
		
		model.addAttribute("reservation", reservation);
		model.addAttribute("clientId", reservation.getClient().getId());
		
		return "reservation-form";
	}
	
	@GetMapping("/addNewReservation/{clientId}")
	public String addReservation(@PathVariable int clientId, Model model) {
		
		Reservation reservation = new Reservation();
		
		Client client = clientService.getClient(clientId);
		reservation.setClient(client);
		
		model.addAttribute("reservation", reservation);
		model.addAttribute("clientId", clientId);
		
		return "reservation-form";
		
	}
	
	@PostMapping("/save")
	public String saveReservation(@ModelAttribute("reservation") Reservation reservation) {

		reservationService.saveReservation(reservation);
		int clientId = reservation.getClient().getId();
		return "redirect:/reservation/clientReservations/" + clientId;
		
	}
	
	@GetMapping("/deleteReservation/{reservationId}")
	public String deleteReservation(@PathVariable int reservationId, Model model) {

		reservationService.deleteReservation(reservationId);

		return "redirect:/web/clients";
	}
	
}
