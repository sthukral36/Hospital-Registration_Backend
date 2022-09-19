package com.hospitalDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalDetails.entity.Patient;
import com.hospitalDetails.exceptions.NotFoundPatient;
import com.hospitalDetails.services.HospitalServices;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerPatient {

    @Autowired
    HospitalServices service;
    
    @GetMapping("/patients/all")
    public List<Patient> showallpatient(){
    	return service.getallpatient();
    }
    
    @GetMapping("/patients/patient/{id}")
    public Patient showPatientInformation(@PathVariable Integer id){
        Patient patient = service.showPatientInformation(id);
        if(patient == null){
            throw new NotFoundPatient(id + "details are not present in database");
        }
        return patient;
    }

    @PostMapping("patients/patient")
    public boolean createPatient(@RequestBody Patient patient){
        service.savePatientInformation(patient);
        return true;
    }

}