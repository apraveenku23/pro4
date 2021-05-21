package com.cts.itreat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.itreat.model.status;
import com.cts.itreat.repository.DoctorsRepository;

@RestController
public class doctorsController {
	@Autowired
	private DoctorsRepository usersRepository;
	
	
	
	
	
	@DeleteMapping("users/all")
	public status deleteUser() {
		usersRepository.deleteAll();
		return status.SUCCESS;
	}
	
	
		
	
	
}
