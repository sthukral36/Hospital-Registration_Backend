package com.hospitalDetails.services;

import java.util.*;

import com.hospitalDetails.entity.Doctor;
import com.hospitalDetails.entity.Patient;

 

 

public interface HospitalServices {
	public Doctor showDoctorInformation(String name);
    public Patient showPatientInformation(Integer Id);
    public boolean saveDoctorInformation(Doctor doctor);
    public boolean savePatientInformation(Patient patient);
    public List<Patient> getPatientListOfDoctor(String name,Doctor doctor);
    public List<Doctor> getDoctors();
    public List<Patient> getallpatient();

}
