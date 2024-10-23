package org.example.aplikaceproskolu.objekty;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;
import lombok.Data;

@Entity
@Data
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "user_id",unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO  )
    public UUID id;

    @OneToMany(mappedBy = "userId")
    public Set<Problem> problems;

    @Column(name = "name")
    public String name;

    @Column(name = "email")
    public String email;

    public User() {}

}