package com.adobe.prj.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.prj.entity.Rental;
import com.adobe.prj.service.RentalService;

@RestController
@RequestMapping("/api/rental")
public class RentalController {
	@Autowired
	private RentalService service;
	
	@PostMapping()
	private @ResponseBody Rental rentVehicle(@RequestBody Rental rental) {
		rental.setRentalDate(new Date());
		return service.rentVehicle(rental);
	}
}
