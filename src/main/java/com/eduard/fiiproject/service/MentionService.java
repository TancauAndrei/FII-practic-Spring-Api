package com.eduard.fiiproject.service;

import com.eduard.fiiproject.entity.Mention;
import com.eduard.fiiproject.entity.Post;
import com.eduard.fiiproject.entity.User;

import java.util.List;

public interface MentionService {

    void create(Mention mention);
    List<Post> getMentions(User user);
}
