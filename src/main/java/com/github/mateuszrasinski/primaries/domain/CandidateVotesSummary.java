package com.github.mateuszrasinski.primaries.domain;

import lombok.Data;

@Data
public class CandidateVotesSummary {
    private final Candidate candidate;
    private final long voteCount;
}
