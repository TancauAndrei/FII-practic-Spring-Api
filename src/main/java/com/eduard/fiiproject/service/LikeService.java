package com.eduard.fiiproject.service;

import com.eduard.fiiproject.entity.Like;

import java.util.List;

public interface LikeService {
    void create(Like like);
    void delete(Integer id  );
    Like getLike(String username, Integer postId);
    List<Like> getByPostId(int postId);
}
