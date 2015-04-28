package com.github.mateuszrasinski.primaries.domain;

import java.util.List;
import lombok.Data;

@Data
public class Summary {
    private final List<CandidateVotesSummary> candidateVotesSummaries;
    private final AllVotesSummary allVotesSummary;
}
