package com.hospitalDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hospitalDetails.entity.Doctor;


@Repository

@CrossOrigin(origins = "http://localhost:4200")
public interface DoctorRepo  extends CrudRepository<Doctor , Integer>{

	Doctor findByName(String name);

}
