package com.github.mateuszrasinski.primaries.view;

import com.github.mateuszrasinski.primaries.domain.Candidate;
import com.github.mateuszrasinski.primaries.domain.CandidateRepository;
import com.github.mateuszrasinski.primaries.view.dto.VoteForm;
import java.util.List;
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
        model.addAttribute("voteForm", new VoteForm(candidates));
        return "index";
    }
}
