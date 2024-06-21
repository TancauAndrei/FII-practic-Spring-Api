package com.eduard.fiiproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "mentions")
@Component
public class Mention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mention_id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
    @ManyToOne
    @JoinColumn(name = "mentioned_username")
    private User mentionedUser;

    public Mention() {
    }


    public User getAllByKeyword() {
        return user;
    }

    public void setUser(User follower) {
        this.user = follower;
    }

    public User getMentionedUser() {
        return this.mentionedUser;
    }

    public void setMentionedUser(User mentionedUser) {
        this.mentionedUser = mentionedUser;
    }

    public int getId() {
        return mention_id;
    }

    public void setId(int id) {
        this.mention_id = id;
    }

}
