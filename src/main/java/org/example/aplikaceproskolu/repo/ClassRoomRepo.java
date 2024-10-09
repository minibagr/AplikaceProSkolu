package org.example.aplikaceproskolu.repo;

import org.example.aplikaceproskolu.objekty.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassRoomRepo extends JpaRepository <ClassRoom, UUID> {
}
