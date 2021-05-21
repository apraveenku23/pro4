package com.cts.itreat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.itreat.model.GeneratePassword;
import com.cts.itreat.model.Logins;
import com.cts.itreat.model.Patient;
import com.cts.itreat.model.Doctors;
import com.cts.itreat.model.status;
import com.cts.itreat.repository.DoctorsRepository;
import com.cts.itreat.repository.LoginsRepository;
import com.cts.itreat.repository.PatientRepository;

@RestController
public class LoginsController {
	@Autowired
	private LoginsRepository loginsRepository;
	@Autowired
	private DoctorsRepository doctorsRepository;
	@Autowired
	private PatientRepository patientRepository;
	@PostMapping("Login/register")
	public status getUsersForDoctors(@RequestBody Doctors user) {
		String Username = user.getDfname();
		String Usernamef = "d_" +Username;
		String password = GeneratePassword.generateRandomPassword(10);
		boolean isLogin = true;
		Logins logins = new Logins();
		logins.setUsername(Usernamef);
		logins.setPassword(password);
		logins.setLoggedIn(isLogin);
		loginsRepository.save(logins);
		doctorsRepository.save(user);
		return status.SUCCESS;
	}
	@PostMapping("Doctors/addPatient")
	public status getUsersForPatient(@RequestBody Patient patient) {
		String Username = patient.getPfname();
		String Usernamef = "p_" +Username;
		String password = GeneratePassword.generateRandomPassword(10);
		boolean isLogin = false;
		Logins logins = new Logins();
		logins.setUsername(Usernamef);
		logins.setPassword(password);
		logins.setLoggedIn(isLogin);
		loginsRepository.save(logins);
		patientRepository.save(patient);
		return status.SUCCESS;
	}
	
	@GetMapping(path="Login/{username}/")
	public @ResponseBody Logins showPasswords(@PathVariable("username") String uname){
		List<Logins> l = loginsRepository.findAll();
		for(Logins l1: l) {
			
			if(l1.getUsername()==uname) {
				return l1;
			}
		}
		return l.get(0);
	}
	
	@PostMapping("Logins/login")
	public status loginUser(@RequestBody Logins login) {
		List<Logins> l = loginsRepository.findAll();
		for(Logins l2 : l) {
			if(l2.equals(login)) {
				login.setLoggedIn(true);
				loginsRepository.save(login);
				return status.SUCCESS;
			}
		}
		return status.FAILURE;
	}
	
	@PostMapping("users/logout")
	public status usersLogout(){
		List<Logins> l = loginsRepository.findAll();
			for(Logins l2 : l) {
				if(l2.isLoggedIn()==true) {
					l2.setLoggedIn(false);
					loginsRepository.save(l2);
					return status.SUCCESS;
				}
			}
			return status.FAILURE;
	}
	
	
}
