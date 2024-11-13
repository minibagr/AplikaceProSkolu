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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(mappedBy = "userId")
    private Set<Problem> problems;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "discord_id")
    public String discordId;

    @Column(name = "user_token")
    public UUID token;

    public User() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<Problem> getProblems() {
        return problems;
    }

    public void setProblems(Set<Problem> problems) {
        this.problems = problems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}