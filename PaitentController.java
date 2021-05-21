package com.cts.itreat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.itreat.model.Patient;
import com.cts.itreat.model.status;
import com.cts.itreat.repository.PatientRepository;

@RestController
public class PaitentController {
	@Autowired
	private PatientRepository patientRepository;
	@GetMapping("doctors/patientsList")
	public List<Patient> getPatientsList(){
		return patientRepository.findAll();
	}
	
	@DeleteMapping("doctors/delete")
	public status deletePatient(@RequestBody Patient patient) {
		List<Patient> p = patientRepository.findAll();
		System.out.println("Deleting paitent"+patient.toString());
		for(Patient p2 : p) {
			if(p2.equals(patient)) {
				patientRepository.delete(patient);
				System.out.println("Paitent deleted");
				return status.SUCCESS;
			}
			
		}
		return status.PATIENT_NOT_EXISTS;
	}
	
}
