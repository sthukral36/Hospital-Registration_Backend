package com.hospitalDetails.servicesImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalDetails.entity.Doctor;
import com.hospitalDetails.entity.Patient;
import com.hospitalDetails.repository.DoctorRepo;
import com.hospitalDetails.repository.PatientRepo;
import com.hospitalDetails.services.HospitalServices;

@Repository
@Transactional
public class ServicesHospitalImpl implements HospitalServices {

	@Autowired
	DoctorRepo doctorRepo;
	@Autowired
	PatientRepo patientRepo;

	@Override
	public Doctor showDoctorInformation(String name) {
		return doctorRepo.findByName(name);
	}

	@Override
	public Patient showPatientInformation(Integer id) {
		return patientRepo.findById(id).get();
	}

	@Override
	public boolean saveDoctorInformation(Doctor doctor) {
		doctorRepo.save(doctor);
		return true;
	}

	@Override
	public boolean savePatientInformation(Patient patient) {

		Doctor doctor = doctorRepo.findByName(patient.getDoctor_name());
		doctor.addPatients(patient);
		patientRepo.save(patient);
		doctor.setPatient_count();
		return true;
	}

	@Override
	public List<Patient> getPatientListOfDoctor(String name, Doctor doctor) {
		return doctor.getPatients();
	}

	@Override
	public List<Doctor> getDoctors() {
		return (List<Doctor>) doctorRepo.findAll();
	}

	@Override
	public List<Patient> getallpatient() {
		return (List<Patient>) patientRepo.findAll();
	}
}