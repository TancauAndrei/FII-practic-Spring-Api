package com.eduard.fiiproject.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "likes")
@Component
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int like_id;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public Like() {
    }

    public User getAllByKeyword() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getId() {
        return like_id;
    }

    public void setId(int id) {
        this.like_id = id;
    }
}
