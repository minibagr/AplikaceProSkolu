package org.example.aplikaceproskolu.objekty;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "CLASROOM")
public class ClassRoom {
    @Id
    @Column(name = "class_id",unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column(name = "name")
    public String name;

    public ClassRoom() {}
}
