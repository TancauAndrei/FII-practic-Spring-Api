package com.eduard.fiiproject.service;

import com.eduard.fiiproject.entity.Follow;
import com.eduard.fiiproject.entity.User;

import java.util.List;

public interface FollowService{
    void create(Follow follow);
    void delete(String username, String followerUsername);
    boolean exists(String username, String followerUsername);
    List<User> getFollowers(String username);
}
