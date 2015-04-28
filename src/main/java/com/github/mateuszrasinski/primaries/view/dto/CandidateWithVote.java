package com.github.mateuszrasinski.primaries.view.dto;

import com.github.mateuszrasinski.primaries.domain.Candidate;
import lombok.Data;

@Data
public class CandidateWithVote {
    private final Candidate candidate;
    private boolean voted;
}
