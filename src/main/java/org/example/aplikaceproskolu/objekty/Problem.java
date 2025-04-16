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
    private UUID id;

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
    private Double time = 0.0;

    @Column(name = "year")
    private Integer year;

    @Column(name="month")
    private Integer month;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Problem() {}

    public UUID getID() {
        return id;
    }

    public void setID(UUID id) {
        this.id = id;
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

    public Users getUserWhoFixedId() {
        return userWhoFixedId;
    }

    public void setUserWhoFixedId(Users userWhoFixedId) {
        this.userWhoFixedId = userWhoFixedId;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }
}