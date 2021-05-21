package com.cts.itreat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.itreat.model.OperationDetails;
import com.cts.itreat.model.status;
import com.cts.itreat.repository.OperationDetailsRepository;

@RestController
public class OperationDetailsController {
	
	@Autowired
	private OperationDetailsRepository operationDetailsRepository;
	@PostMapping("doctor/addOperationDetails")
	public status addOperationDetails(@RequestBody OperationDetails details) {
		operationDetailsRepository.save(details);
		return status.SUCCESS;
	}

}
