package com.github.mateuszrasinski.primaries.view;

import com.github.mateuszrasinski.primaries.domain.Candidate;
import com.github.mateuszrasinski.primaries.domain.CandidateRepository;
import com.github.mateuszrasinski.primaries.dto.VoteForm;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    CandidateRepository candidateRepository;

    @RequestMapping(method = RequestMethod.POST)
    public String vote(@ModelAttribute VoteForm voteForm) {
        Optional<Candidate> candidate = candidateRepository.find(voteForm.getVotedCandidateId());
        System.out.println("Voted for: " + candidate.get());
        return "redirect:?voted=true";
    }
}
