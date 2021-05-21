package com.cts.itreat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.itreat.model.Medicine;
import com.cts.itreat.model.status;
import com.cts.itreat.repository.MedicineRepository;

@RestController
public class medicineController {

	
	@Autowired
	private MedicineRepository medicineRepository;
	
	@GetMapping("doctor/patient/{medid}")
	public Medicine getMedicine(@RequestParam("medid") Long id) {
		return medicineRepository.findById(id).get();
	}
	
	@PostMapping("doctor/addmedicine")
	public status addMedicine(@RequestBody Medicine medicine) {
		medicineRepository.save(medicine);
		return status.SUCCESS;
	}
	@DeleteMapping("doctor/removeMedicine")
	public status removeMedicine(@RequestBody Medicine medicine) {
		medicineRepository.delete(medicine);
		return status.SUCCESS;
	}
	@PostMapping("doctors/updateMedicine")
	public status updateSchedule(@RequestBody Medicine medicine) {
		Long id = medicine.getMedid();
		medicineRepository.deleteById(id);
		medicineRepository.save(medicine);
		return status.SUCCESS; 
	}
	
}
