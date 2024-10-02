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
    public String Name;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    public User UserId;

    @Column(name = "core_problem")
    public String Core;

    @Column(name = "coment")
    public String Coment;

    @Column(name = "created")
    public Date Created;
    @Column(name = "started")
    public Date Started;
    @Column(name = "ended")
    public Date Ended;

}