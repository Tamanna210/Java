package com.adobe.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.RentalDao;
import com.adobe.prj.entity.Rental;

@Service
public class RentalService {
	@Autowired
	private RentalDao rentalDao;
	
	public Rental rentVehicle(Rental rental) {
		return rentalDao.save(rental);
	}
}
