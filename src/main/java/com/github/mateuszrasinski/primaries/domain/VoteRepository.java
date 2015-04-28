package com.github.mateuszrasinski.primaries.domain;

public interface VoteRepository {
    void save(Vote vote);
    long countTotal();
    long countVotesFor(Candidate candidate);
}
