package com.github.mateuszrasinski.primaries.domain;

import java.util.UUID;
import lombok.Data;

@Data
public class Candidate {
    private final String id = UUID.randomUUID().toString();
    private final String firstName;
    private final String secondName;
    private final String lastName;
    private final int age;
}
