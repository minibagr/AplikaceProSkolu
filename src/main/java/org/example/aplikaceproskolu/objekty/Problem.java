package org.example.aplikaceproskolu.objekty;

import jakarta.persistence.*;
import lombok.Data;
import org.example.aplikaceproskolu.repo.ClassRoomRepo;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "PROBLEM")
public class Problem {

    @Id
    @Column(name = "problem_id",unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ID;

    @Column(name = "problem_name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = true)
    private User userId;

    @ManyToOne()
    @JoinColumn(name = "class_id", nullable = true)
    private ClassRoom classId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created")
    private Date created;
    @Column(name = "started")
    private Date started;
    @Column(name = "ended")
    private Date ended;

    public Problem() {}

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassRoom getClassId() {
        return classId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getEnded() {
        return ended;
    }

    public void setEnded(Date ended) {
        this.ended = ended;
    }

    public String getName() {
        return name;
    }

    public User getUserId() {
        return userId;
    }

    public String getComment() {
        return comment;
    }

    public void setUserId(User user) {
        this.userId = user;
    }

    public void setClassId(ClassRoom classId) {
        this.classId = classId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}