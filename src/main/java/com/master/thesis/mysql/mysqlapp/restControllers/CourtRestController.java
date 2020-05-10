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

import com.master.thesis.mysql.mysqlapp.entity.Court;
import com.master.thesis.mysql.mysqlapp.service.CourtService;

@RestController
@RequestMapping("/api")
public class CourtRestController {

	@Autowired
	CourtService courtService;

	@GetMapping("/courts")
	public List<Court> getCourts() {

		return courtService.getCourts();
	}

	@GetMapping("/courts/{courtId}")
	public Court getCourt(@PathVariable int courtId) {

		return courtService.getCourt(courtId);

	}

	@PostMapping("/courts")
	public Court addCourt(@RequestBody Court theCourt) {

		// set id to 0 force to save a new item and not to update it
		theCourt.setId(0);

		courtService.saveCourt(theCourt);

		return theCourt;
	}

	@PutMapping("/courts")
	public Court updateCourt(@RequestBody Court theCourt) {
		
		courtService.updateCourt(theCourt);

		return theCourt;

	}

	@DeleteMapping("/courts/{courtId}")
	public String deleteCourt(@PathVariable int courtId) {

		Court theCourt = courtService.getCourt(courtId);

		if (theCourt == null) {
			return "Set proper court id to remove";
		}

		courtService.deleteCourt(courtId);

		return "Court with id: " + courtId + " removed";

	}

}
