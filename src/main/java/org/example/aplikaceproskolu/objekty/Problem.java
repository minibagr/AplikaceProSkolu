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
    private UUID ID;

    @Column(name = "problem_name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = true)
    private Users userId;

    @ManyToOne()
    @JoinColumn(name = "class_id", nullable = true)
    private ClassRoom classId;

    @ManyToOne()
    @JoinColumn(name = "user_fix_id")
    private Users fixUserId;

    @ManyToOne()
    @JoinColumn(name = "user_who_fixed_id")
    private Users userWhoFixedId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created")
    private Date created;

    @Column(name = "time")
    private Integer time;

    @Column(name = "pinned", nullable = true)
    public boolean isPinned;

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

    public String getName() {
        return name;
    }

    public Users getUserId() {
        return userId;
    }

    public String getComment() {
        return comment;
    }

    public void setUserId(Users user) {
        this.userId = user;
    }

    public void setClassId(ClassRoom classId) {
        this.classId = classId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Users getFixUserId() {
        return fixUserId;
    }

    public void setFixUserId(Users fixUserId) {
        this.fixUserId = fixUserId;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }

    public Users getUserWhoFixedId() {
        return userWhoFixedId;
    }

    public void setUserWhoFixedId(Users userWhoFixedId) {
        this.userWhoFixedId = userWhoFixedId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}