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

import com.master.thesis.mysql.mysqlapp.entity.Reservation;
import com.master.thesis.mysql.mysqlapp.service.ReservationService;

@RestController
@RequestMapping("/api")
public class ReservationRestController {
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/reservations")
	public List<Reservation> getReservations() {
		
		return reservationService.getReservations();
		
	}
	
	@GetMapping("/reservations/{reservationId}")
	public Reservation getReservation(@PathVariable int reservationId) {
		
		return reservationService.getReservation(reservationId);

	}
	
	@PutMapping("/reservations")
	public void updateReservation(@RequestBody Reservation reservation) {
		
		reservationService.updateReservation(reservation);
		
	}
	
	@PostMapping("/reservations")
	public Reservation saveReservation(@RequestBody Reservation reservation) {

		reservation.setId(0);
		
		return reservationService.saveReservation(reservation); 
		
	}
	
	@DeleteMapping("/reservations/{reservationId}")
	public String deleteReservation(@PathVariable int reservationId) {
		
		Reservation reservation = reservationService.getReservation(reservationId);
		
		if ( reservation == null) 
			return "There wasn't reservation with that id";
		
		reservationService.deleteReservation(reservationId);
		
		return "We delete reservation with id: " + reservationId;
		
	}
	
}
