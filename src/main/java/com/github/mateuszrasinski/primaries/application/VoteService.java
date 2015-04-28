package com.github.mateuszrasinski.primaries.application;

import com.github.mateuszrasinski.primaries.domain.AllVotesSummary;
import com.github.mateuszrasinski.primaries.domain.Candidate;
import com.github.mateuszrasinski.primaries.domain.CandidateRepository;
import com.github.mateuszrasinski.primaries.domain.CandidateVotesSummary;
import com.github.mateuszrasinski.primaries.domain.Summary;
import com.github.mateuszrasinski.primaries.domain.Vote;
import com.github.mateuszrasinski.primaries.domain.VoteRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    private final CandidateRepository candidateRepository;
    private final VoteRepository voteRepository;

    @Autowired
    public VoteService(CandidateRepository candidateRepository, VoteRepository voteRepository) {
        this.candidateRepository = candidateRepository;
        this.voteRepository = voteRepository;
    }

    public void saveVoteForCandidate(String votedCandidateId) {
        Vote vote = new Vote(votedCandidateId);
        voteRepository.save(vote);
    }

    public Summary summary() {
        List<CandidateVotesSummary> candidateVotesSummaries = candidateVotesSummaries();
        AllVotesSummary allVotesSummary = allVotesSummary();
        return new Summary(candidateVotesSummaries, allVotesSummary);
    }

    public List<CandidateVotesSummary> candidateVotesSummaries() {
        List<Candidate> candidates = candidateRepository.findAll();
        return candidates.stream()
                         .map(this::createCandidateVotesSummary)
                         .collect(Collectors.toList());
    }

    private CandidateVotesSummary createCandidateVotesSummary(Candidate candidate) {
        long voteCountForCandidate = voteRepository.countVotesFor(candidate);
        return new CandidateVotesSummary(candidate, voteCountForCandidate);
    }

    public AllVotesSummary allVotesSummary() {
        long totalVoteCount = voteRepository.countTotal();
        return new AllVotesSummary(totalVoteCount);
    }
}
