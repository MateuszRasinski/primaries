package com.github.mateuszrasinski.primaries.domain;

import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class Vote {
    private final String candidateId;
    private final OffsetDateTime dateTime;

    public Vote(String candidateId) {
        this.candidateId = candidateId;
        this.dateTime = OffsetDateTime.now();
    }
}
