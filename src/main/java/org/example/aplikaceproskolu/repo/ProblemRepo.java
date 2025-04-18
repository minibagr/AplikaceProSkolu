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

    @Query("SELECT COUNT(p) FROM Problem p WHERE p.userId = :user AND p.time > 0")
    int countProblemSolvedByUser(@Param("user") Users user);

    @Query("SELECT SUM(p.time) FROM Problem p WHERE p.userId = :user")
    double sumTimeSpendOnProblemFromUser(@Param("user") Users user);

    List<Problem> getAllByUserId(Users user);

    @Query("SELECT p FROM Problem p WHERE p.time = 0 AND p.year = :year AND p.month = :month")
    List<Problem> getNotCompleted(@Param("year") int year, @Param("month") int month, Sort sort);

    @Query("SELECT p FROM Problem p WHERE p.time > 0")
    List<Problem> getCompleted(Sort sort);

    @Query("SELECT p FROM Problem p WHERE p.month = :month AND p.year = :year")
    List<Problem> getProblemByMonthAndYear(@Param("year") int year, @Param("month") int month, Sort sort);
}
