package org.example.aplikaceproskolu.repo;

import org.example.aplikaceproskolu.objekty.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<Users, UUID> {
    Users findByToken(UUID token);

    Users findByName(String username);

    Users findByEmail(String email);

//    @Query("SELECT u FROM Users u WHERE u.discordId = :discordId")
//    Users findByDiscordId(@Param("discordId") String discordId);

//    @Query("SELECT u FROM Users u WHERE u.role = :role")
//    List<Users> getByRole(@Param("role") int role);
}
