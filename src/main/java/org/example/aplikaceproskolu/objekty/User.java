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
    public UUID ID;

    @OneToMany(mappedBy = "UserId")
    public Set<Problem> Problems;

    @Column(name = "name")
    public String Name;

    @Column(name = "email")
    public String Email;

}