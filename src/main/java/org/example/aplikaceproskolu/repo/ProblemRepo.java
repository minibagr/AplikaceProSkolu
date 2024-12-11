package org.example.aplikaceproskolu.repo;

import org.example.aplikaceproskolu.objekty.Problem;
import org.example.aplikaceproskolu.objekty.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProblemRepo extends JpaRepository<Problem, UUID> {
    @Query("SELECT COUNT(p) FROM Problem p WHERE p.userId = :user")
    int countProblemByUser(@Param("user") Users user);

    @Query("SELECT COUNT(p) FROM Problem p WHERE p.userId = :user AND p.ended IS NOT NULL")
    int countProblemNotSolvedByUser(@Param("user") Users user);
}
