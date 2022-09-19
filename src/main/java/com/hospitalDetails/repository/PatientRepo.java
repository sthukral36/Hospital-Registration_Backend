package com.hospitalDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hospitalDetails.entity.Patient;

@Repository

public interface PatientRepo extends CrudRepository<Patient ,Integer> {
	

}
