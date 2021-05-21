package com.cts.itreat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.itreat.model.Schedule;
import com.cts.itreat.model.status;
import com.cts.itreat.repository.ScheduleRepository;

@RestController
public class ScheduleController {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@GetMapping("doctor/patient/{pid}")
	public Schedule getSchedule(@RequestParam("pid") Long id) {
		return scheduleRepository.findById(id).get();
	}
	
	@PostMapping("doctor/addSchedule")
	public status addSchedule(@RequestBody Schedule schedule){
		scheduleRepository.save(schedule);
		return status.SUCCESS;
	}
	
	@DeleteMapping("doctor/removeSchedule")
	public status removeSchedule(@RequestBody Schedule schedule) {
		scheduleRepository.delete(schedule);
		return status.SUCCESS;
	}
	@PostMapping("doctors/updateSchedule")
	public status updateSchedule(@RequestBody Schedule schedule) {
		scheduleRepository.deleteById(1L);
		scheduleRepository.save(schedule);
		return status.SUCCESS; 
	}
	
}
