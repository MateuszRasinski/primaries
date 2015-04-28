package com.github.mateuszrasinski.primaries.view;

import com.github.mateuszrasinski.primaries.application.VoteService;
import com.github.mateuszrasinski.primaries.domain.Candidate;
import com.github.mateuszrasinski.primaries.domain.CandidateRepository;
import com.github.mateuszrasinski.primaries.view.dto.VoteForm;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/vote")
public class VoteController {
    private final CandidateRepository candidateRepository;
    private final VoteService voteService;

    @Autowired
    public VoteController(CandidateRepository candidateRepository, VoteService voteService) {
        this.candidateRepository = candidateRepository;
        this.voteService = voteService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String vote(@ModelAttribute VoteForm voteForm) {
        String votedCandidateId = voteForm.getVotedCandidateId();
        Optional<Candidate> candidate = candidateRepository.find(votedCandidateId);
        System.out.println("Voted for: " + candidate);
        voteService.saveVoteForCandidate(votedCandidateId);
        return "redirect:summary";
    }
}
