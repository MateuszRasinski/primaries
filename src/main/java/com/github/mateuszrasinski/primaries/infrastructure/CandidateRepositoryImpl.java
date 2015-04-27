package com.github.mateuszrasinski.primaries.infrastructure;

import java.util.List;

import com.github.mateuszrasinski.primaries.domain.Candidate;
import com.github.mateuszrasinski.primaries.domain.CandidateRepository;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Repository;

@Repository
public class CandidateRepositoryImpl implements CandidateRepository {
	private final List<Candidate> candidates = ImmutableList.of(
			new Candidate("Janusz", "Ryszard", "Korwin-Mikke", 72),
			new Candidate("Bronisław", "Maria", "Komorowski", 60),
			new Candidate("Andrzej", null, "Duda", 50));

	public List<Candidate> findAll() {
		return candidates;
	}
}
