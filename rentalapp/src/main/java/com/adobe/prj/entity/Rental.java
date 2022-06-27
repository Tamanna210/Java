package com.adobe.prj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="rentals")
public class Rental {
	@Id
	@Column(name="rental_id")
	private int rentalId;
	
	@ManyToOne
	@JoinColumn(name="customer_fk")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="vehicle_fk")
	private Vehicle vehicle;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="rental_date")
	private Date rentalDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="return_date")
	private Date returnDate ;

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
	
}
