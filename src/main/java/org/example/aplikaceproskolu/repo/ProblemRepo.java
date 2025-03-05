package org.example.aplikaceproskolu.repo;

import jakarta.transaction.Transactional;
import org.example.aplikaceproskolu.objekty.Problem;
import org.example.aplikaceproskolu.objekty.Users;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface ProblemRepo extends JpaRepository<Problem, UUID> {
    @Query("SELECT COUNT(p) FROM Problem p WHERE p.userId = :user")
    int countProblemByUser(@Param("user") Users user);

    @Query("SELECT COUNT(p) FROM Problem p WHERE p.userId = :user AND p.time IS NOT NULL")
    int countProblemNotSolvedByUser(@Param("user") Users user);

    @Query("SELECT SUM(p.time) FROM Problem p WHERE p.userId = :user")
    double sumTimeSpendOnProblemFromUser(@Param("user") Users user);

    List<Problem> getAllByUserId(Users user);

    @Query("SELECT p FROM Problem p WHERE p.time IS NULL")
    List<Problem> getNotCompleted(Sort sort);

    @Query("SELECT p FROM Problem p WHERE p.time IS NOT NULL")
    List<Problem> getCompleted(Sort sort);
}
