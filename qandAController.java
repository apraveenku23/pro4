package com.cts.itreat.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cts.itreat.model.QandA;
import com.cts.itreat.model.status;
import com.cts.itreat.repository.QandARepository;

@RestController
public class qandAController {

	@Autowired
	private QandARepository aRepository;
	
	@PostMapping("paitent/addQuestion")
	public  status addquestion(@RequestBody QandA qandA) {
		aRepository.save(qandA);
		return status.SUCCESS;
	}
	// how to add answer with this
	@PostMapping("doctors/addAnswer")
	public status addAnswer(@RequestBody QandA qandA) {
		String ques = qandA.getQuestion();
		String ans = qandA.getAnswer();
		List<QandA> qa= aRepository.findAll();
		for (QandA qandA2 : qa) {
			if(qandA2.getQuestion()==ques) {
				qandA2.setAnswer(ans);
				return status.SUCCESS;
			}
		}
		return status.FAILURE;
	}
	
	@DeleteMapping("paitent/removeQuestion")
	public status deleteQuestions(@RequestBody QandA qandA) {
		aRepository.delete(qandA);
		return status.SUCCESS;
	}
	
}
