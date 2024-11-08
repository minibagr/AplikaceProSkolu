package org.example.aplikaceproskolu.repo;

import org.example.aplikaceproskolu.objekty.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
}
