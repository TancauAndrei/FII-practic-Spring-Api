package com.eduard.fiiproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "replies")
@Component
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reply_id;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post_id",nullable = false)
    private Post parent;

    @Column
    private String message;
    private boolean isPublic;

    public Reply(User userById, Post postById, String message) {
        this.user = userById;
        this.parent = postById;
        this.isPublic = true;
        this.message = message;
    }
    public Reply() {}

    public Reply(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public User getAllByKeyword() {
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

    public Post getParent() {
        return parent;
    }

    public void setParent(Post parent) {
        this.parent = parent;
    }

    public int getId() {
        return reply_id;
    }

    public void setId(int id) {
        this.reply_id = id;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
