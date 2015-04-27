package com.github.mateuszrasinski.primaries.domain;

import java.util.List;

public interface CandidateRepository {
	List<Candidate> findAll();
}
