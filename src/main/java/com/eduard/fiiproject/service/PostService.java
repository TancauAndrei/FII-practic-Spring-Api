package com.eduard.fiiproject.service;

import com.eduard.fiiproject.entity.Post;

import java.time.LocalDateTime;
import java.util.List;

public interface PostService {
     List<Post> getPosts();
     List<Post> getOwn(String username);
     List<Post> getOwnNewerThan(String username, LocalDateTime time);
     void create(Post post);
     void delete(Integer postId);
     void update(Post post);
    Post getById(Integer postId);
}