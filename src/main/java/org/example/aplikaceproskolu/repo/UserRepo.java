package org.example.aplikaceproskolu.repo;

import org.example.aplikaceproskolu.objekty.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    @Query("SELECT u FROM User u WHERE u.token = :#{#token}")
    User findByToken(UUID token);

    @Query("SELECT u FROM User u WHERE u.discordId = :#{#discordId}")
    User findByDiscordId(String discordId);
}
