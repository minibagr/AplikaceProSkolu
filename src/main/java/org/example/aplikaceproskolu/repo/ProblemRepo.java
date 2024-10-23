package org.example.aplikaceproskolu.repo;

import org.example.aplikaceproskolu.objekty.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProblemRepo extends JpaRepository<Problem, UUID> {
}
