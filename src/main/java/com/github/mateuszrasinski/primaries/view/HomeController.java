package com.github.mateuszrasinski.primaries.view;

import java.util.List;

import com.github.mateuszrasinski.primaries.domain.Candidate;
import com.github.mateuszrasinski.primaries.domain.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	CandidateRepository candidateRepository;

	@RequestMapping("/")
	public String index(Model model) {
		List<Candidate> candidates = candidateRepository.findAll();
		model.addAttribute("candidates", candidates);
		return "index";
	}
}
