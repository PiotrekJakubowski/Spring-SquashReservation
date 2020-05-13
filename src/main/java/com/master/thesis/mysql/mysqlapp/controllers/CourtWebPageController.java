package com.master.thesis.mysql.mysqlapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.master.thesis.mysql.mysqlapp.entity.Court;
import com.master.thesis.mysql.mysqlapp.service.CourtService;
import com.master.thesis.mysql.mysqlapp.service.ReservationService;

@Controller
@RequestMapping("/court")
public class CourtWebPageController {

	@Autowired
	CourtService courtService;

	@Autowired
	ReservationService reservationService;

	@GetMapping("/courtInformation")
	public String displayAllCourst(Model model) {

		List<Court> theCourts = courtService.getCourts();

		model.addAttribute("courts", theCourts);

		return "court-table";

	}

	@GetMapping("/courtInformation/{courtId}")
	public String displayCourt(@PathVariable int courtId, Model model) {

		Court court = courtService.getCourt(courtId);

		System.out.println("Court: " + court);

		model.addAttribute("court", court);

		return "court-form";
	}

	@PostMapping("/save")
	public String saveCourt(@ModelAttribute("court") Court court) {

		courtService.saveCourt(court);

		return "redirect:/court/courtInformation/";

	}

	@GetMapping("/delete/{courtId}")
	public String deleteClient(@PathVariable int courtId, Model model) {

		reservationService.deleteAllReservationsForCourt(courtId);

		courtService.deleteCourt(courtId);

		return "redirect:/court/courtInformation";
	}
	
	@GetMapping("/addCourt")
	public String addCourt(Model model) {
		
		Court court = new Court();
		
		model.addAttribute("court", court);
		
		return "court-form";
		
	}

}
