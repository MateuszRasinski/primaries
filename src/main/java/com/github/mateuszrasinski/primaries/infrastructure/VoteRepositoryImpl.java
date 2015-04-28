package com.github.mateuszrasinski.primaries.infrastructure;

import com.github.mateuszrasinski.primaries.domain.Candidate;
import com.github.mateuszrasinski.primaries.domain.Vote;
import com.github.mateuszrasinski.primaries.domain.VoteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class VoteRepositoryImpl implements VoteRepository {
    private final List<Vote> votes = new ArrayList<>();

    @Override
    public void save(Vote vote) {
        votes.add(vote);
    }

    @Override
    public long countTotal() {
        return votes.size();
    }

    @Override
    public long countVotesFor(Candidate candidate) {
        return votes.stream()
                    .filter(vote -> vote.getCandidateId().equals(candidate.getId()))
                    .count();
    }
}
