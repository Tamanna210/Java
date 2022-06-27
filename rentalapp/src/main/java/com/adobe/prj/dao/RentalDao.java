package com.adobe.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adobe.prj.entity.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer> {

}
