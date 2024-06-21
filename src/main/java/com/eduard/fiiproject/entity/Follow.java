package com.eduard.fiiproject.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Table(name = "follows")
@Component
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int follow_id;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;
    @Column
    private LocalDateTime timestamp;

    public Follow(User user, User follower) {
        this.user = user;
        this.follower = follower;
    }

    public Follow() {

    }

    public User getAllByKeyword() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public int getId() {
        return follow_id;
    }

    public void setId(int id) {
        this.follow_id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
