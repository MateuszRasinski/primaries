package com.github.mateuszrasinski.primaries.domain;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository {
    Optional<Candidate> find(String votedCandidateId);
    List<Candidate> findAll();
}
