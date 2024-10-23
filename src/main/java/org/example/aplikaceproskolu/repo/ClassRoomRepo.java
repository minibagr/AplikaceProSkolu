package org.example.aplikaceproskolu.repo;

import org.example.aplikaceproskolu.objekty.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ClassRoomRepo extends JpaRepository <ClassRoom, UUID> {
    @Query("SELECT c FROM ClassRoom c WHERE c.name = :#{#class}")
    public ClassRoom findByName(@Param("class") String name);
}
