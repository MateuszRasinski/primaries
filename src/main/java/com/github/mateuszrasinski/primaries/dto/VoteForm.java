package com.github.mateuszrasinski.primaries.dto;

import com.github.mateuszrasinski.primaries.domain.Candidate;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VoteForm {
    private List<Candidate> candidates;
    private String votedCandidateId;

    public VoteForm(List<Candidate> candidates) {
        this.candidates = candidates;
    }
}
