package com.master.thesis.mysql.mysqlapp.restControllers;

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

import com.master.thesis.mysql.mysqlapp.entity.Court;
import com.master.thesis.mysql.mysqlapp.repository.CourtRepository;
import com.master.thesis.mysql.mysqlapp.service.CourtService;
import com.master.thesis.mysql.mysqlapp.service.ReservationService;

@RestController
@RequestMapping("/api")
public class CourtRestController {

	CourtRepository courtRepository;
	ReservationService reservationService;

	@Autowired
	public CourtRestController(CourtRepository courtRepository, ReservationService reservationService) {
		this.courtRepository = courtRepository;
		this.reservationService = reservationService;
	}
	

	@GetMapping("/courts")
	public Iterable<Court> getCourts() {

		return courtRepository.findAll();
	}

	@GetMapping("/courts/{courtId}")
	public Optional<Court> getCourt(@PathVariable int courtId) {

		return courtRepository.findById(courtId);

	}

	@PostMapping("/courts")
	public Court addCourt(@RequestBody Court theCourt) {

		// set id to 0 force to save a new item and not to update it
		theCourt.setId(0);

		courtRepository.save(theCourt);
		
		return theCourt;
	}

	@PutMapping("/courts")
	public Court updateCourt(@RequestBody Court theCourt) {
		
		courtRepository.save(theCourt);
		
		return theCourt;

	}

	@DeleteMapping("/courts/{courtId}")
	public String deleteCourt(@PathVariable int courtId) {

		Optional<Court> theCourt = courtRepository.findById(courtId);

		if (theCourt == null) {
			return "Set proper court id to remove";
		}
		
		reservationService.deleteAllReservationsForCourt(courtId);

		courtRepository.deleteById(courtId);

		return "Court with id: " + courtId + " removed";

	}

}
