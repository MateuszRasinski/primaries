package com.github.mateuszrasinski.primaries.dto;

import com.github.mateuszrasinski.primaries.domain.Candidate;
import lombok.Data;

@Data
public class CandidateWithVote {
    private final Candidate candidate;
    private boolean voted;
}
