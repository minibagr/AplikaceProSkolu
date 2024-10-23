package org.example.aplikaceproskolu.objekty;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "PROBLEM")
public class Problem {

    @Id
    @Column(name = "problem_id",unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID ID;

    @Column(name = "problem_name")
    public String name;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = true)
    public User userId;

    @Column(name = "core_problem")
    public String core;

    @Column(name = "comment")
    public String comment;

    @Column(name = "created")
    public Date created;
    @Column(name = "started")
    public Date started;
    @Column(name = "ended")
    public Date ended;

    public Problem() {}

}