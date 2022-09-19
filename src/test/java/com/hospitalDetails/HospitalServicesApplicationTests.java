package com.hospitalDetails;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospitalDetails.controller.ControllerDoctor;

import com.hospitalDetails.entity.Doctor;

import com.hospitalDetails.repository.DoctorRepo;

@SpringBootTest
class HospitalServicesApplicationTests {

	@Autowired
	DoctorRepo repository;

	@Autowired
	ControllerDoctor controller;

	@Test
	void testAdd() {
		Doctor doctor = new Doctor("Dr Ab", 44, "Female", "Orthologist");

		boolean addDoctor = controller.addUser(doctor);
		assertEquals(repository.findByName("Dr Ab").getName(), doctor.getName());

	}

}
