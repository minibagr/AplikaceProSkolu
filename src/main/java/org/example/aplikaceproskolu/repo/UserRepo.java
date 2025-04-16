package org.example.aplikaceproskolu.repo;

import org.example.aplikaceproskolu.objekty.Users;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface UserRepo extends JpaRepository<Users, UUID> {
    Users findByToken(UUID token);

    Users findByName(String username);

    Users findByEmail(String email);

    @Query("SELECT u, COUNT(p.id) AS problem_count FROM Users u JOIN Problem p ON u.id=p.userId.id WHERE p.month = :month AND p.year = :year GROUP BY u.id")
    List<Object[]> getUsersByMostProblems(@Param("year") int year, @Param("month") int month, Sort sort);

    @Query("SELECT u, COUNT(p.id) AS problem_count FROM Users u JOIN Problem p ON u.id=p.userWhoFixedId.id WHERE p.month = :month AND p.year = :year GROUP BY p.userWhoFixedId")
    List<Object[]> getUsersByProblemSolved(@Param("year") int year, @Param("month") int month, Sort sort);

//    @Query("SELECT u FROM Users u WHERE u.discordId = :discordId")
//    Users findByDiscordId(@Param("discordId") String discordId);

//    @Query("SELECT u FROM Users u WHERE u.role = :role")
//    List<Users> getByRole(@Param("role") int role);
}
