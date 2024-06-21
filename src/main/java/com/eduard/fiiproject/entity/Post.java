package com.eduard.fiiproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
@Component
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;
    @NotEmpty
    @Column
    private String message;
    @DateTimeFormat
    private LocalDateTime timestamp;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public Post(String message) {
        this.message = message;
    }

    public Post() {

    }

    public Post(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public int getId() {
        return post_id;
    }

    public void setId(int post_id) {
        this.post_id = post_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
